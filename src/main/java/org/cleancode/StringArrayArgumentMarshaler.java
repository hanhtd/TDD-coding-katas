package org.cleancode;

import java.util.Iterator;

// TODO: Will be implemented
public class StringArrayArgumentMarshaler implements ArgumentMarshaler {

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {

    }

    public static String[] getValue(ArgumentMarshaler argumentMarshaler) {
        return new String[0];
    }
}
