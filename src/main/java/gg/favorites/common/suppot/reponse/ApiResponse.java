package gg.favorites.common.suppot.reponse;

import lombok.Getter;

@Getter
public class ApiResponse<S> {

    private final ResultType result;

    private final S data;

    private final String error;

    private ApiResponse(ResultType result, S data, String error) {
        this.result = result;
        this.data = data;
        this.error = error;
    }

    public static ApiResponse<?> success() {
        return new ApiResponse<>(ResultType.SUCCESS, null, null);
    }

    public static <S> ApiResponse<S> success(S data) {
        return new ApiResponse<>(ResultType.SUCCESS, data, null);
    }

    public static ApiResponse<?> error(String error) {
        return new ApiResponse<>(ResultType.ERROR, null, error);
    }

}