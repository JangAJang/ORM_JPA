package entity.items;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue(("M"))
public class Movie extends Book{
    private String director;
    private String actor;

}
