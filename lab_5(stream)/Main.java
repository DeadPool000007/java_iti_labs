import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Optional;
import java.util.stream.Collectors;


class CityEntry
{
    public int id;
    public City city;
    public CityEntry(int id,City city)
    {
        this.id=id;
        this.city=city;
    }

}

class CountryEntry
{
    public String code;
    public Country country;
    public CountryEntry(Map.Entry<String,Country> e)
    {
        this.code=e.getKey();
        this.country=e.getValue();
    }
}


public class Main {

    public static void main(String[] args) {

        InMemoryWorldDao myworld=	InMemoryWorldDao.getInstance();
        Set<String> conts=myworld.getContinents();
        Map<String, Country> countr=myworld.getCountries();
        Map<Integer, City> citiess=myworld.getCities();




        List<Country> countrList= countr.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());

        List<City> mostCountryCity = countrList.stream().map(c -> c.getCities().stream()
                .reduce( new City(0,"","", 0), (x,y) -> x.getPopulation()>y.getPopulation()?x:y)
        ).collect(Collectors.toList());

        for(City c : mostCountryCity) {
            System.out.println(c.getName());
        }
        List<City> countryMaxCont = conts.stream()
                .map(continent -> countrList.stream()
                        .filter(c -> continent.equals(c.getContinent()))
                        .flatMap(c -> c.getCities().stream())
                        .reduce((c1, c2) -> c1.getPopulation() > c2.getPopulation() ? c1 : c2)
                        .orElse(null)).collect(Collectors.toList());

        for(City c : countryMaxCont)
        {
            if(c!=null)
                System.out.println(c.getName() );
        }
        Country mcc = countrList.stream().filter(x ->  citiess.get(x.getCapital()) != null)
                .reduce(countrList.get(0),(x,y) -> citiess.get(x.getCapital()).getPopulation()>citiess.get(y.getCapital()).getPopulation()?x:y);
        City cap =  citiess.get(mcc.getCapital());
        System.out.println("Capital : "+cap.getName() );






    }

}