package com.lcwd.user.service.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hotel {
    private String hotelId;
    private String name;
    private String location;
    private String about;
}
