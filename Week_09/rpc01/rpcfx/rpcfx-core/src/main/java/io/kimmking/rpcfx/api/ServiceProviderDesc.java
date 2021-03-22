package io.kimmking.rpcfx.api;

import lombok.Builder;
import lombok.Data;

/**
 * ServiceProviderDesc
 *
 * @author KevinChen
 * @since 21/3/2021
 */
@Data
@Builder
public class ServiceProviderDesc {
    private String host;
    private Integer port;
    private String serviceClass;
}
