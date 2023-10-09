package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@ToString
@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class SettingsDTO {
    @JsonProperty("toolbar")
    private ToolbarDTO toolbar;

    @JsonProperty("grid")
    private GridDTO grid;

    @JsonProperty("treemap")
    private TreemapDTO treemap;

    @JsonProperty("cards")
    private CardsDTO cards;

    @JsonProperty("wizard")
    private WizardDTO wizard;

    @JsonProperty("charts")
    private ChartsDTO charts;

    @JsonProperty("geocharts")
    private GeochartsDTO geocharts;

    @JsonProperty("connections")
    private ConnectionsDTO connections;

    @JsonProperty("pipeline")
    private PipelineDTO pipeline;

    @JsonProperty("pivot")
    private PivotDTO pivot;

    @JsonProperty("timeline")
    private TimelineDTO timeline;

    @JsonProperty("filtersModal")
    private FiltersModalDTO filtersModal;

    @JsonProperty("detailsPopup")
    private DetailsPopupDTO detailsPopup;

    @JsonProperty("legend")
    private LegendDTO legend;
}
