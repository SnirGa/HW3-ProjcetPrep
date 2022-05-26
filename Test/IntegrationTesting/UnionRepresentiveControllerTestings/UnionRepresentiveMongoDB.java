package IntegrationTesting.UnionRepresentiveControllerTestings;

import DataAccess.LeagueDaoMongoDB;
import Domain.ManagementSystem.League;
import Domain.ManagementSystem.LeagueSeason;
import Domain.ManagementSystem.UnionRepresentive;
import org.junit.Test;

import java.time.LocalDate;

public class UnionRepresentiveMongoDB {
    @Test
    public void save(){
        LeagueDaoMongoDB leagueDaoMongoDB=LeagueDaoMongoDB.getInstance();
        League league=new League("mdskc",new UnionRepresentive("Scsdmk","Dcmsdkcd","sdcsmc"));
        LocalDate start=LocalDate.of(2211,12,1);
        LocalDate end=LocalDate.of(2211,1,1);
        LeagueSeason ls=new LeagueSeason(league,120,start,end);
        league.addLeagueSeason(ls);
        leagueDaoMongoDB.save(league);
    }
}
