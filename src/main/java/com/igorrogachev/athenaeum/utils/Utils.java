package com.igorrogachev.athenaeum.utils;

import com.igorrogachev.athenaeum.utils.constants.ModelAttributeNameConstants;
import org.springframework.ui.Model;

public class Utils {

    public static void exceptionProcessing(Model model, Exception e, String errDescriptionPrefix) {
        StringBuffer err = new StringBuffer(errDescriptionPrefix).append(e.getMessage());
        if (e.getCause() != null) {
            err.append(" # e.getCause() # ").append(e.getCause().getMessage());
        }
        // для целей понимания какие классы эксепшенов возбуждаются добавим сюда еще и класс эксепшена
        err.append(" # Exsepion Class: ").append(e.getClass());
        model.addAttribute(ModelAttributeNameConstants.SOME_EXCEPTION, err.toString());
    }
}
