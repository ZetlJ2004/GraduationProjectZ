package org.example.backend.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backend.exception.Code;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO {
    private int code;
    private String msg;
    private Object data;

    private static final ResultVO EMPTY = ResultVO.builder()
            .code(100)
            .msg("操作成功！")
            .build();

    public static ResultVO ok() {
        return EMPTY;
    }

    public static ResultVO success(Object data) {
        return ResultVO.builder()
                .code(200)
                .msg("操作成功！")
                .data(data)
                .build();
    }

    public static ResultVO error(Code code) {

        return ResultVO.builder()
                .code(code.getNumber())
                .msg(code.getMessage())
                .build();
    }

    public static ResultVO error(int number, String message) {

        return ResultVO.builder()
                .code(number)
                .msg(message)
                .build();
    }
}
