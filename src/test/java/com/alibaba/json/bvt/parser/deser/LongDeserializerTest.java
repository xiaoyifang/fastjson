package com.alibaba.json.bvt.parser.deser;

import junit.framework.TestCase;

import org.junit.Assert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultExtJSONParser;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.LongCodec;

public class LongDeserializerTest extends TestCase {

    public void test_bigdecimal() throws Exception {
        Assert.assertEquals(0, JSON.parseObject("0", Long.class).intValue());
        Assert.assertEquals(0, JSON.parseObject("0.0", Long.class).intValue());
        Assert.assertEquals(0, JSON.parseObject("'0'", Long.class).intValue());

        Assert.assertEquals(null, JSON.parseObject("null", Long.class));

        DefaultExtJSONParser parser = new DefaultExtJSONParser("null", ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
        Assert.assertEquals(null, LongCodec.instance.deserialize(parser, null, null));
        Assert.assertEquals(JSONToken.LITERAL_INT, LongCodec.instance.getFastMatchToken());
    }
}
