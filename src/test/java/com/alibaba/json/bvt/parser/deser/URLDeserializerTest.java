package com.alibaba.json.bvt.parser.deser;

import java.net.URL;

import junit.framework.TestCase;

import org.junit.Assert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultExtJSONParser;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.URLCodec;

public class URLDeserializerTest extends TestCase {

    public void test_url() throws Exception {
        Assert.assertEquals(new URL("http://www.alibaba.com"), JSON.parseObject("'http://www.alibaba.com'", URL.class));

        Assert.assertEquals(null, JSON.parseObject("null", URL.class));

        DefaultExtJSONParser parser = new DefaultExtJSONParser("null", ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
        Assert.assertEquals(null, URLCodec.instance.deserialize(parser, null, null));
        Assert.assertEquals(JSONToken.LITERAL_STRING, URLCodec.instance.getFastMatchToken());

    }

    public void test_url_error() throws Exception {
        JSONException ex = null;
        try {
            JSON.parseObject("'123'", URL.class);
        } catch (JSONException e) {
            ex = e;
        }
        Assert.assertNotNull(ex);
    }
}
