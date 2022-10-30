package org.example.Model;

import lombok.Builder;
import org.example.Model.Managers.Director;

@Builder
public class Organization {
    Founder founder;
    Director director;
}
