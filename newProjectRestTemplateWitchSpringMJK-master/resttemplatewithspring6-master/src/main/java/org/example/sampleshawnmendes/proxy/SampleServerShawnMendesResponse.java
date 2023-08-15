package org.example.sampleshawnmendes.proxy;

import java.util.List;

public record SampleServerShawnMendesResponse(
        String message,
        List<String> songsName
) {
}
