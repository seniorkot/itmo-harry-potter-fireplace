package ru.fireplaces.harrypotter.itmo.domain.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fireplaces.harrypotter.itmo.domain.enums.ClaimStatus;
import ru.fireplaces.harrypotter.itmo.domain.model.Claim;
import ru.fireplaces.harrypotter.itmo.domain.model.Fireplace;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * {@link Claim} JPA repository interface.
 *
 * @author seniorkot
 */
@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {

    /**
     * Fetches all {@link Claim} entities by status.
     *
     * @param pageable {@link Pageable} params
     * @param status Claim status
     * @return {@link Page} with fetched {@link Claim} entities
     */
    Page<Claim> findAllByStatus(Pageable pageable, ClaimStatus status);

    /**
     * Fetches all {@link Claim} entities by user ID.
     *
     * @param pageable {@link Pageable} params
     * @param userId User ID
     * @return {@link Page} with fetched {@link Claim} entities
     */
    Page<Claim> findAllByUserId(Pageable pageable, Long userId);

    /**
     * Fetches all {@link Claim} entities by status and user ID.
     *
     * @param pageable {@link Pageable} params
     * @param status Claim status
     * @param userId User ID
     * @return {@link Page} with fetched {@link Claim} entities
     */
    Page<Claim> findAllByStatusAndUserId(Pageable pageable, ClaimStatus status, Long userId);

    /**
     * Fetches {@link Claim} by departure time and {@link Fireplace}.
     *
     * @param departureTime Departure date and time
     * @param departure Departure fireplace
     * @return Fetched {@link Claim}
     */
    Optional<Claim> findByDepartureTimeAndDeparture(LocalDateTime departureTime, Fireplace departure);

    /**
     * Fetches {@link Claim} by departure time and destination {@link Fireplace}.
     *
     * @param departureTime Departure date and time
     * @param arrival Arrival fireplace
     * @return Fetched {@link Claim}
     */
    Optional<Claim> findByDepartureTimeAndArrival(LocalDateTime departureTime, Fireplace arrival);

    /**
     * Returns bool value of {@link Claim} existence by
     * departure time and destination {@link Fireplace}.
     *
     * @param departureTime Departure date and time
     * @param departure Departure fireplace
     * @return
     */
    boolean existsByDepartureTimeAndDeparture(LocalDateTime departureTime, Fireplace departure);

    /**
     * Returns bool value of {@link Claim} existence by
     * departure time and destination {@link Fireplace}.
     *
     * @param departureTime Departure date and time
     * @param arrival Arrival fireplace
     * @return
     */
    boolean existsByDepartureTimeAndArrival(LocalDateTime departureTime, Fireplace arrival);
}
