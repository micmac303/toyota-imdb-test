package com.timeless.toyotaimdbtest.service;


import com.timeless.toyotaimdbtest.model.TitleRating;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component @Slf4j
public class TitleRatingItemProcessor implements ItemProcessor<TitleRating, String> {

    @Override
    public String process(TitleRating titleRating) throws Exception {

        if (titleRating.getNumVotes() >= 2000000) {
            log.info("\n\nProcessing title rating: {}", titleRating);
            return titleRating.getTconst() + "\n\n";
        }
        return null;
    }
}