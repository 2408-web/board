package com.example.board_final.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemDTO {
    @JsonProperty("가구평균감량")
    private String a;
    @JsonProperty("가구평균감량률")
    private String b;
    @JsonProperty("가구평균배출량")
    private String c;
//     "가구평균감량": "6.8",
//             "가구평균감량률": "82.9",
//             "가구평균배출량": "8.2",
//             "기간1": 2024,
//             "기간2": 9,
//             "지역1": "인천광역시",
//             "지역2": null,
//             "지역3": "연수구"
}
