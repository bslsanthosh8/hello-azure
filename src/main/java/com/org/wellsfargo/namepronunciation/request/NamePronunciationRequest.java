package com.org.wellsfargo.namepronunciation.request;

import com.org.wellsfargo.namepronunciation.entity.NamePronunciation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class NamePronunciationRequest {

    String uid;
    String format;
    String createdBy;

   public static NamePronunciation getNamePronunciation(NamePronunciationRequest namePronunciationRequest) {
        NamePronunciation namePronunciation = new NamePronunciation();
        namePronunciation.setFormat(namePronunciationRequest.getFormat());
        namePronunciation.setUid(namePronunciationRequest.getUid());
        namePronunciation.setCreatedTimestamp(new Date());
        namePronunciation.setModifiedTimestamp(new Date());
        namePronunciation.setCreatedBy(namePronunciationRequest.getCreatedBy());
        return namePronunciation;
    }

}
