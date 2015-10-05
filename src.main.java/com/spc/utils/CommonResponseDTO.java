package com.spc.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by YogeshK on 2015-10-05.
 */
@Getter
@Setter
public abstract class CommonResponseDTO {
    private String responseCode;
    private String responseMessage;
}
