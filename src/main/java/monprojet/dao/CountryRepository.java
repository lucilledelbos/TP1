package monprojet.dao;
import monprojet.dto.PopulationPays;
import java.util.List;

import monprojet.dto.PopulationPays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query(value = "SELECT  SUM(city.population) "
            + "FROM country INNER JOIN city on country.id = city.country_id  "
            + "WHERE country.id = :pop_id", nativeQuery = true)

    public int populationPays(int pop_id);



    @Query(value = "Select country.name as nom, sum(city.population) as pop "
            + "from country inner join city on country.id = city.country_id  "
            + " group by country.id ", nativeQuery = true)

    public List<PopulationPays> listePopulation();
}
