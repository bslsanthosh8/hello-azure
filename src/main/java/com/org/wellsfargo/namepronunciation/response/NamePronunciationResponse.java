package com.org.wellsfargo.namepronunciation.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NamePronunciationResponse<T> {

    private String status;
    private T data;
    private String  error;

}
