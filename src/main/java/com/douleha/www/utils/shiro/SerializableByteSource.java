package com.douleha.www.utils.shiro;

import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

/**
 * Created by ivan_ on 2015/8/18.
 */
public class SerializableByteSource extends SimpleByteSource implements Serializable {

    public SerializableByteSource(byte[] bytes) {
        super(bytes);
    }

    public SerializableByteSource(char[] chars) {
        super(chars);
    }

    public SerializableByteSource(String string) {
        super(string);
    }

    public SerializableByteSource(ByteSource source) {
        super(source);
    }

    public SerializableByteSource(File file) {
        super(file);
    }

    public SerializableByteSource(InputStream stream) {
        super(stream);
    }
}
