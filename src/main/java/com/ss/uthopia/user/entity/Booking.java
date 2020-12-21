package com.ss.uthopia.user.entity;

import javax.persistence.*;

@Entity(name = "booking")
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "booking_id")
    private long bookingId;

    @ManyToOne()
    @JoinColumns({
            @JoinColumn(name="booker_id", referencedColumnName="user_id")
    })
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "booking_travelers",
            joinColumns = {@JoinColumn(name = "booking_id", referencedColumnName = "booking_id")},
    inverseJoinColumns = {@JoinColumn(name = "traveler_id", referencedColumnName = "traveler_id")})
    private Traveler traveler;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "stripe_id")
    private String stripeId;

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User users) {
        this.user = users;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getStripeId() {
        return stripeId;
    }

    public void setStripeId(String stripeId) {
        this.stripeId = stripeId;
    }

    public Traveler getTraveler() {
        return traveler;
    }

    public void setTraveler(Traveler traveler) {
        this.traveler = traveler;
    }
}
