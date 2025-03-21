package com.lgitsolution.switcheshopcommon.common.util;

import java.io.Serializable;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class OffsetBasedPageRequest implements Pageable, Serializable {

  private static final long serialVersionUID = -25822477129613575L;

  private int limit;
  private long offset;
  private final Sort sort;

  /**
   * Creates a new {@link OffsetBasedPageRequest} with sort parameters applied.
   *
   * @param offset zero-based offset.
   * @param limit the size of the elements to be returned.
   * @param sort can be {@literal null}.
   */
  public OffsetBasedPageRequest(long offset, int limit, Sort sort) {
    if (offset < 0) {
      throw new IllegalArgumentException("Offset index must not be less than zero!");
    }

    if (limit < 1) {
      throw new IllegalArgumentException("Limit must not be less than one!");
    }
    this.limit = limit;
    this.offset = offset;
    this.sort = sort;
  }

  /**
   * Creates a new {@link OffsetBasedPageRequest} with sort parameters applied.
   *
   * @param offset zero-based offset.
   * @param limit the size of the elements to be returned.
   * @param sort can be {@literal null}.
   */
  public OffsetBasedPageRequest(Sort sort) {
    this.sort = sort;
    this.offset = 0;
    this.limit = Integer.MAX_VALUE;
  }


  /**
   * Creates a new {@link OffsetBasedPageRequest} with sort parameters applied.
   *
   * @param offset zero-based offset.
   * @param limit the size of the elements to be returned.
   */
  public OffsetBasedPageRequest(int offset, int limit) {
    this(offset, limit, Sort.unsorted());
  }

  @Override
  public int getPageNumber() {
    return (int) (offset / limit);
  }

  @Override
  public int getPageSize() {
    return limit;
  }

  @Override
  public long getOffset() {
    return offset;
  }

  @Override
  public Sort getSort() {
    return sort;
  }

  @Override
  public Pageable next() {
    return new OffsetBasedPageRequest(getOffset() + getPageSize(), getPageSize(), getSort());
  }

  public OffsetBasedPageRequest previous() {
    return hasPrevious() ? new OffsetBasedPageRequest(getOffset() - getPageSize(), getPageSize(),
            getSort()) : this;
  }

  @Override
  public Pageable previousOrFirst() {
    return hasPrevious() ? previous() : first();
  }

  @Override
  public Pageable first() {
    return new OffsetBasedPageRequest(0, getPageSize(), getSort());
  }

  @Override
  public Pageable withPage(int pageNumber) {
    return this;
  }

  @Override
  public boolean hasPrevious() {
    return offset > limit;
  }

}
