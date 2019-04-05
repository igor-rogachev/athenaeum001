package com.igorrogachev.athenaeum.service;

import com.igorrogachev.athenaeum.service.constants.ModelAttributeNameConstants;
import org.springframework.ui.Model;

public class Utils {

    public static void exceptionProcessing(Model model, Exception e, String errDescriptionPrefix) {
        String err = errDescriptionPrefix + e.getMessage();
        if (e.getCause() != null) {
            err = err + " # e.getCause() # " + e.getCause().getMessage();
        }
        model.addAttribute(ModelAttributeNameConstants.SOME_EXCEPTION, err);
    }
}
