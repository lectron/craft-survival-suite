package com.iKeirNez.Minecraftly.configuration;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.WordUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by iKeirNez on 04/02/14.
 */
public enum Setting {

    NEWBIE__ENABLED, NEWBIE__COMMAND, NEWBIE__EXPIRY_COMMAND, NEWBIE__MINUTES, NEWBIE__MESSAGE, NEWBIE__EXPIRY_MESSAGE,
    CHAT__ENABLED, CHAT__SMART_MUTE, CHAT__LOCAL_RANGE, CHAT__LOCAL_FORMAT, CHAT__GLOBAL_FORMAT, CHAT__GLOBAL_PREFIX,
    BLOCK_SERVER_MESSAGE__JOIN, BLOCK_SERVER_MESSAGE__QUIT, BLOCK_SERVER_MESSAGE__KICKED,
    RESTART__ENABLED, RESTART__COUNTDOWN, RESTART__MESSAGE,
    VOTE__ENABLED, VOTE__TIMED_COMMAND, VOTE__EXPIRY_COMMAND, VOTE__TIME, VOTE__ONE_TIME_COMMANDS, VOTE__NOTIFY,
        VOTE__EXTRA_REWARDS__VOTE, VOTE__EXTRA_REWARDS__PER_MINUTES, VOTE__EXTRA_REWARDS__ONE_TIME_COMMANDS,
    COLOR__PREFIX, COLOR__SUFFIX, COLOR__PREFIX_COLOR, COLOR__SUFFIX_COLOR, COLOR__PREFIX_FORMAT, COLOR__SUFFIX_FORMAT,
    COLOR__CHAT_COLOR, COLOR__CHAT_FORMAT, COLOR__NAME_TAG, COLOR__TABLIST_COLOR,
    GRIEF_PREVENTION__ENABLED, GRIEF_PREVENTION__BUY_OFFER, GRIEF_PREVENTION__SELL_OFFER,

    DEBUG;

    @Getter @Setter Object value = null;
    @Getter String comment = null;

    public int intValue(){
        return (int) value;
    }

    public long longValue(){
        return (long) value;
    }

    public boolean booleanValue(){
        return (boolean) value;
    }

    public String stringValue(){
        return (String) value;
    }

    public List<String> stringListValue(){
        return (List<String>) value;
    }

    public List listValue(){
        return (List) value;
    }

    public Map<String, Object> mapValue(){
        return (Map<String, Object>) value;
    }

    public boolean hasComment(){
        return comment != null;
    }

    public String toConfigPath(){
        return WordUtils.capitalize(name().toLowerCase().replaceAll("__", ".").replaceAll("_", " ")).replaceAll(" ", "");
    }

}
