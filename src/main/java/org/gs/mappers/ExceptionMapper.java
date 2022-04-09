package org.gs.mappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gs.exceptions.KeyloggerException;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import javax.ws.rs.core.Response;

public class ExceptionMapper {

    private static final Logger logger = LogManager.getLogger(ExceptionMapper.class);

    @ServerExceptionMapper
    public RestResponse<String> mapException(KeyloggerException x) {
        logger.error(x);
        return RestResponse.status(x.response, x.getMessage());
    }

    @ServerExceptionMapper
    public RestResponse<String> mapException(Throwable x) {
        logger.error(x);
        return RestResponse.status(Response.Status.BAD_REQUEST, x.getMessage());
    }
}
