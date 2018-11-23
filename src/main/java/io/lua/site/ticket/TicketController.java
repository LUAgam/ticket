package io.lua.site.ticket;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import io.lua.entity.Response;
import io.lua.entity.pojo.TicketRequest;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @ProjectName: ticket
 * @Package: io.lua.site.ticket
 * @Description:
 * @Author: AMGuo
 * @CreateDate: 2018-11-23 16:18
 * @Version: 1.0
 */
@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Resource
    private TicketService ticketService;

    @GetMapping("/")
    public Response get(@Valid TicketRequest ticketRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Response.buildErrorResponse(bindingResult.getFieldError().getDefaultMessage());
        }
        String result = ticketService.findData(ticketRequest);
        return Response.buildSuccessResponse(result);
    }

}
