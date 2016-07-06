package com.tkb.elearning.util.editor;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.DateFormat;
import org.apache.log4j.Logger;

/**
 * @author Ken
 * @version 創建時間2016-01-25
 */
public class TimestampEditor extends PropertyEditorSupport {
	final Logger logger = Logger.getLogger(getClass());

    DateFormat dateFormat;

    public TimestampEditor(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setAsText(String text) throws IllegalArgumentException {
        try {
            setValue(new Timestamp(dateFormat.parse(text).getTime()));
        } catch (Exception e) {
            setValue(null);
        }
    }

    public String getAsText() {
         Timestamp value = (Timestamp) getValue();
         return (value != null ? this.dateFormat.format(value) : "");
    }
}