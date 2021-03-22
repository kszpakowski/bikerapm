package pl.kszpakowski.bikeramp.api.stats;


import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kszpakowski.bikeramp.api.stats.dto.MonthlyStatsDto;
import pl.kszpakowski.bikeramp.api.stats.dto.WeeklyStatsDto;
import pl.kszpakowski.bikeramp.app.stats.StatsService;

import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/stats")
@RequiredArgsConstructor
public class StatsController {

    private final StatsService statsService;
    private final StatsMapper mapper;

    @ApiOperation(value = "Get Weekly Stats", notes = "This endpoint retrieves how many kilometers did courier rode during current week and how much money he received on the rides.")
    @GetMapping("/weekly")
    public WeeklyStatsDto getWeeklyStats() {

        return mapper.map(statsService.getWeeklyStats());
    }

    @ApiOperation(value = "Get Monthly Stats", notes = "This endpoint retrieves summary of ride distances from current month, grouped by day. The summary should include sum of all rides distances from given day, average ride distance and average price for the ride.")
    @GetMapping("/monthly")
    public Collection<MonthlyStatsDto> getMonthlyStats() {
        return statsService.getMonthlyStats().stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }
}
