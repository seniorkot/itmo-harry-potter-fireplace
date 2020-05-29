package ru.fireplaces.harrypotter.itmo.fireplace.domain.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import ru.fireplaces.harrypotter.itmo.fireplace.domain.model.Fireplace;
import ru.fireplaces.harrypotter.itmo.utils.interfaces.model.request.RequestRequiredFields;
import ru.fireplaces.harrypotter.itmo.utils.json.JsonDatetimeDeserializer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * {@link ru.fireplaces.harrypotter.itmo.fireplace.domain.model.Claim}
 * POJO. Used in request bodies.
 *
 * @author seniorkot
 */
@Data
public class ClaimRequest implements RequestRequiredFields {

    /**
     * Departure fireplace ID.
     */
    private Long departureId;

    /**
     * Arrival fireplace ID.
     */
    private Long arrivalId;

    /**
     * Departure date and time.
     */
    @JsonDeserialize(using = JsonDatetimeDeserializer.class)
    private Date departureTime;

    /**
     * Departure fireplace (to copy).
     */
    @JsonIgnore
    private Fireplace departure;

    /**
     * Departure arrival (to copy).
     */
    @JsonIgnore
    private Fireplace arrival;

    @Override
    public List<String> getBlankRequiredFields() {
        List<String> list = new ArrayList<>();
        if (this.departureId == null) {
            list.add("departureId");
        }
        if (this.arrivalId == null) {
            list.add("arrivalId");
        }
        if (this.departureTime == null) {
            list.add("departureTime");
        }
        return list;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $departureId = this.getDepartureId();
        result = result * PRIME + ($departureId == null ? 43 : $departureId.hashCode());
        final Object $arrivalId = this.getArrivalId();
        result = result * PRIME + ($arrivalId == null ? 43 : $arrivalId.hashCode());
        final Object $departureTime = this.getDepartureTime();
        result = result * PRIME + ($departureTime == null ? 43 : $departureTime.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClaimRequest(departureId=" + this.getDepartureId()
                + ", arrivalId=" + this.getArrivalId()
                + ", departureTime=" + this.getDepartureTime() + ")";
    }
}