//package com.hzhiping.contract;
//
//import feign.Headers;
//import feign.MethodMetadata;
//import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * @author hzhiping
// * @date 2023/01/15
// */
//@Service
//public class MyFeignContract extends SpringMvcContract {
//    /**
//     * 该属性是为了使用SpringCloud Config
//     */
//    private ResourceLoader resourceLoader;
//
//    @Override
//    protected void processAnnotationOnClass(MethodMetadata data, Class<?> clz) {
//        //这里复用原有SpringMvcContract逻辑
//        super.processAnnotationOnClass(data, clz);
//
//        //以下是新加的逻辑（其实是使用的openfeign自带的Contract.Default的逻辑）
//        if (clz.isAnnotationPresent(Headers.class)) {
//            String[] headersOnType = clz.getAnnotation(Headers.class).value();
//            Map<String, Collection<String>> headers = toMap(headersOnType);
//            headers.putAll(data.template().headers());
//            data.template().headers(null); // to clear
//            data.template().headers(headers);
//        }
//    }
//
//    private Map<String, Collection<String>> toMap(String[] input) {
//        Map<String, Collection<String>> result = new LinkedHashMap<>(input.length);
//        for (String header : input) {
//            int colon = header.indexOf(':');
//            String name = header.substring(0, colon);
//            if (!result.containsKey(name)) {
//                result.put(name, new ArrayList<>(1));
//            }
//            result.get(name).add(resolve(header.substring(colon + 1).trim()));
//        }
//        return result;
//    }
//
//    private String resolve(String value) {
//        if (StringUtils.hasText(value) && resourceLoader instanceof ConfigurableApplicationContext) {
//            return ((ConfigurableApplicationContext) this.resourceLoader).getEnvironment()
//                    .resolvePlaceholders(value);
//        }
//        return value;
//    }
//
//    @Override
//    public void setResourceLoader(ResourceLoader resourceLoader) {
//        this.resourceLoader = resourceLoader;
//        //注意，因为SpringMvcContract也使用了resourceLoader，所以必须给它指定解析器，否则不会解析占位符
//        super.setResourceLoader(resourceLoader);
//    }
//}