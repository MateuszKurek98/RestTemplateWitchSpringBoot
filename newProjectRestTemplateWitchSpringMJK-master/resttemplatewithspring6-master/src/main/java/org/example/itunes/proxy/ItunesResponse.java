package org.example.itunes.proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public record ItunesResponse(Integer ResultCount,
                             List<ItunesResult> results) {
}
