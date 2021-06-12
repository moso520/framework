package wechat.services;

import io.restassured.builder.ResponseBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import wechat.util.HttpUtil;

public class TokenFilter implements Filter {
    private final static TokenFilter tokenFilter = new TokenFilter();

    private TokenFilter(){}

    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
        filterableRequestSpecification.queryParam("access_token", HttpUtil.getgetAccessToken());
        Response responseOrigin = filterContext.next(filterableRequestSpecification,filterableResponseSpecification);
        Response responseAction = new ResponseBuilder().clone(responseOrigin).build();
        return responseAction;
    }

    public static TokenFilter getTokenFilter(){
        return tokenFilter;
    }
}
