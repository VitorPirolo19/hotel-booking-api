INSERT INTO rooms(number, room_type, capacity_of_people, price_per_night) VALUES
(10, 'SINGLE', 1, 100.00),
(15, 'SUITE', 3,300.00);

INSERT INTO bookings(id, room_number, username, number_of_people, checkin, checkout) VALUES
(1, 10, 'vitor', 1, '2025-07-12T12:00', '2025-07-29T12:00'),
(2, 15, 'anna', 1, '2025-08-01T12:00', '2025-08-15T16:00');