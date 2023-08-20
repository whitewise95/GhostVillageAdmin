package com.example.ghostvillageadmin.app.utils;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PagableDto {

	public enum OrderType {
		ASC(Sort.Direction.ASC),
		DESC(Sort.Direction.DESC);
		public final Sort.Direction dir;

		OrderType(Sort.Direction dir) {
			this.dir = dir;
		}
	}

	@Getter
	@Setter
	public static class Request {

		@Schema(description = "페이지", example = "1", required = true)
		private Integer page = 1;

		@Schema(description = "페이지 당 수", example = "20", required = true)
		private Integer limit = 20;

		@Schema(description = "정렬필드", example = "createdAt")
		private String sortField = "id";

		@Schema(description = "정렬방식", example = "DESC")
		private OrderType orderType = OrderType.DESC;

		public Integer getPage() {
			return page < 1 ? 0 : page - 1;
		}
	}

	@Getter
	@Setter
	public static class Response<T> {

		@Schema(description = "검색 시작 위치")
		private Integer offset = 0;

		@Schema(description = "페이지 당 결과수")
		private Integer limit = 20;

		@Schema(description = "결과 총 수")
		private Long totalCount;

		@Schema(description = "현재 페이지 번호")
		private Integer pageNow;

		@Schema(description = "페이지 총 수")
		private Long pageTotal;

		@Schema(description = "다음 페이지 여부")
		private Boolean isNext = false;

		@Schema(description = "이전 페이지 여부")
		private Boolean isPrev = false;

		@Schema(description = "데이터 정보")
		private List<T> results;


		/**
		 * PagableDto.Response 형태로 반환
		 **/
		public static <X, Y> Response<X> of(Page<Y> page, List<X> dataList) {
			Response<X> result = new Response<>();

			int pageNow = page.getNumber();

			// 검색 시작 위치
			result.setOffset(pageNow * page.getSize());

			pageNow += 1;

			// 페이지 당 결과수
			result.setLimit(page.getSize());

			// 결과 총 수
			result.setTotalCount(page.getTotalElements());

			// 현재 페이지 번호
			result.setPageNow(pageNow);

			// 페이지 총 수
			if (page.getTotalElements() % page.getSize() != 0) {
				result.setPageTotal(page.getTotalElements() / page.getSize() + 1);
			} else {
				result.setPageTotal(page.getTotalElements() / page.getSize());
			}

			// 이전 페이지 여부
			if (pageNow > 1) {
				result.setIsPrev(true);
			}

			// 다음 페이지 여부
			if (pageNow < result.getPageTotal()) {
				result.setIsNext(true);
			}

			// DATA SET
			result.setResults(dataList);

			return result;
		}

		/**
		 * PagableDto.Response 형태로 반환
		 **/
		public static <X> Response<X> of(Request request, List<X> dataList) {
			// 별도 페이징 처리
			if ((request.getPage() - 1) * request.limit > dataList.size()) {
				request.setPage(dataList.size() / request.limit + 1);
			}

			PageRequest pageRequest = PageRequest.of(request.getPage(), request.getLimit());

			// offset
			final int start = (int) pageRequest.getOffset();
			final int end = Math.min((start + pageRequest.getPageSize()), dataList.size());

			Page<X> items = new PageImpl<>(dataList.subList(end == 0 ? end : start, end), pageRequest, dataList.size());

			return PagableDto.Response.of(items, items.getContent());
		}
	}
}

