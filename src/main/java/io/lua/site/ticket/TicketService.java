package io.lua.site.ticket;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import io.lua.constant.Constant;
import io.lua.entity.pojo.TicketRequest;
import io.lua.util.StationUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @ProjectName: ticket
 * @Package: io.lua.site.ticket
 * @Description:
 * @Author: AMGuo
 * @CreateDate: 2018-11-23 16:18
 * @Version: 1.0
 */
@Service
public class TicketService {


    public String findData(TicketRequest ticketRequest) {
        String from = ticketRequest.getFrom().trim();
        String to = ticketRequest.getTo().trim();
        String date = ticketRequest.getDate().trim();
        from = StationUtil.getCodeByName(from);
        to = StationUtil.getCodeByName(to);
        return StationUtil.getTickets(from, to, date);
    }
}
