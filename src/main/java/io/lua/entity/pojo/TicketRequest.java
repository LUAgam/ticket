package io.lua.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * @ProjectName: ticket
 * @Package: io.lua.entity.pojo
 * @Description:
 * @Author: AMGuo
 * @CreateDate: 2018-11-23 18:12
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequest {

    @NotEmpty
    private String from;

    @NotEmpty
    private String to;

    @NotEmpty
    private String date;
}
