package cerlace.tastetrack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PageSettings {
    public static final int DEFAULT_PAGE = 0;
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final String DEFAULT_SORT_FIELD = "id";
    public static final String DEFAULT_SORT_DIRECTION = "asc";

    @Builder.Default
    private int page = DEFAULT_PAGE;
    @Builder.Default
    private int size = DEFAULT_PAGE_SIZE;
    @Builder.Default
    private String sortField = DEFAULT_SORT_FIELD;
    @Builder.Default
    private String sortDirection = DEFAULT_SORT_DIRECTION;
}
