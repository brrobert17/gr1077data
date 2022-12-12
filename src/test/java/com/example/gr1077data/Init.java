package com.example.gr1077data;

import com.example.gr1077data.model.ExternalResearcher;
import com.example.gr1077data.model.Image;
import com.example.gr1077data.model.Location;
import com.example.gr1077data.model.Researcher;
import com.example.gr1077data.service.ExternalResearcherService;
import com.example.gr1077data.service.LocationService;
import com.example.gr1077data.service.ResearcherService;
import com.example.gr1077data.service.exception.SectionsSequenceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Init {
    @Autowired ResearcherService researcherService;
    @Autowired ExternalResearcherService externalResearcherService;
    @Autowired LocationService locationService;
    Researcher researcher;
    ExternalResearcher externalResearcher;
    Location location;

    @Test
    void iResearcher() throws SectionsSequenceException {
        researcher = Researcher.builder().firstName("Alessandro").lastName("Moretti")
                .title("Postdoc").telephone("+4535337791").email("almo@anthro.ku.dk")
                .profileImage(Image.builder().caption("AlessandroMoretti").url("").build())
                .profile("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en/persons/708781")
                .cv("")
                .publications("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Falessandro-moretti(b131a046-5848-4fe2-a7bf-6fc5ffdb2e41)%2Fpublications.html")
                .build();
        researcherService.save(researcher);
        researcher = Researcher.builder().firstName("Anja").lastName("Simonsen")
                .title("Assistant Professor - Tenure Track").telephone("+4535323492").email("anja.simonsen@anthro.ku.dk")
                .profileImage(Image.builder().caption("AnjaSimonsen").url("https://www2.adm.ku.dk/selv/pls/prt_www40.hentindhold_cms?p_personid=342515").build())
                .profile("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en/persons/342515")
                .cv("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Fanja-simonsen(f8c7deb4-567b-4dcc-93d1-febd5ab559d2)%2Fcv.html")
                .publications("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Fanja-simonsen(f8c7deb4-567b-4dcc-93d1-febd5ab559d2)%2Fpublications.html")
                .build();
        researcherService.save(researcher);
        researcher = Researcher.builder().firstName("Atreyee").lastName("Sen")
                .title("Associate Professor").telephone("+4535333882").email("atreyee.sen@anthro.ku.dk")
                .profileImage(Image.builder().caption("AtreyeeSen").url("https://www2.adm.ku.dk/selv/pls/prt_www40.hentindhold_cms?p_personid=504559").build())
                .profile("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en/persons/504559")
                .cv("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Fatreyee-sen(175cfb01-1f08-44c2-a5b2-23d126141695)%2Fcv.html")
                .publications("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Fatreyee-sen(175cfb01-1f08-44c2-a5b2-23d126141695)%2Fpublications.html")
                .build();
        researcherService.save(researcher);
        researcher = Researcher.builder().firstName("Brigit").lastName("Bräuchler")
                .title("Associate Professor").telephone("+4535331308").email("brigit.braeuchler@anthro.ku.dk")
                .profileImage(Image.builder().caption("BrigitBraeuchler").url("").build())
                .profile("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en/persons/692051")
                .cv("")
                .publications("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Fbirgit-brauchler(01302034-6f06-474a-b590-2690f37ee377)%2Fpublications.html")
                .build();
        researcherService.save(researcher);
        researcher = Researcher.builder().firstName("Christina").lastName("Jerne")
                .title("Postdoc").telephone("+4535331995").email("chje@anthro.ku.dk")
                .profileImage(Image.builder().caption("ChristinaJerne").url("").build())
                .profile("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en/persons/628516")
                .cv("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Fchristina-jerne(6de064fc-b2c2-4a86-8b2e-adbf30126627)%2Fcv.html")
                .publications("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Fchristina-jerne(6de064fc-b2c2-4a86-8b2e-adbf30126627)%2Fpublications.html")
                .build();
        researcherService.save(researcher);
        researcher = Researcher.builder().firstName("Erika").lastName("Skov")
                .title("PhD Fellow").telephone("").email("ek@anthro.ku.dk")
                .profileImage(Image.builder().caption("ErikaSkov").url("https://www2.adm.ku.dk/selv/pls/prt_www40.hentindhold_cms?p_personid=458346").build())
                .profile("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en/persons/458346")
                .cv("")
                .publications("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Ferika-skov(e6c42490-83e6-42a8-a583-2dfe0d09338d)%2Fpublications.html")
                .build();
        researcherService.save(researcher);
        researcher = Researcher.builder().firstName("Henrik").lastName("Vigh")
                .title("Professor").telephone("+4535323491").email("hv@anthro.ku.dk")
                .profileImage(Image.builder().caption("HenrikVigh").url("https://www2.adm.ku.dk/selv/pls/prt_www40.hentindhold_cms?p_personid=91300").build())
                .profile("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en/persons/91300")
                .cv("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Fhenrik-vigh(17a13b53-ffe9-49b4-b7f6-995f038c8ace)%2Fcv.html")
                .publications("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Fhenrik-vigh(17a13b53-ffe9-49b4-b7f6-995f038c8ace)%2Fpublications.html")
                .build();
        researcherService.save(researcher);
        researcher = Researcher.builder().firstName("Humphrey").lastName("Asamoah Agyekum")
                .title("Assistant Professor").telephone("+4535330856").email("haa@anthro.ku.dk")
                .profileImage(Image.builder().caption("HumphreyAsamoahAgyekum").url("https://www2.adm.ku.dk/selv/pls/prt_www40.hentindhold_cms?p_personid=439172").build())
                .profile("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en/persons/439172")
                .cv("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Fhumphrey-asamoah-agyekum(c8a940ce-c38f-4ef0-bb0a-dded3c8486a8)%2Fcv.html")
                .publications("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Fhumphrey-asamoah-agyekum(c8a940ce-c38f-4ef0-bb0a-dded3c8486a8)%2Fpublications.html")
                .build();
        researcherService.save(researcher);
        researcher = Researcher.builder().firstName("Ida").lastName("Hartmann")
                .title("Postdoc").telephone("").email("ida.hartmann@anthro.ku.dk")
                .profileImage(Image.builder().caption("IdaHartmann").url("https://www2.adm.ku.dk/selv/pls/prt_www40.hentindhold_cms?p_personid=331615").build())
                .profile("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en/persons/331615")
                .cv("")
                .publications("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Fida-hartmann(aaef53a2-6c35-4ca1-8eb6-2fc0d3677947)%2Fpublications.html")
                .build();
        researcherService.save(researcher);
        researcher = Researcher.builder().firstName("Julie").lastName("Nygaard Solvang")
                .title("PhD Fellow").telephone("+4535328848").email("juliensolvang@anthro.ku.dk")
                .profileImage(Image.builder().caption("JulieNygaardSolvang").url("").build())
                .profile("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en/persons/524484")
                .cv("")
                .publications("")
                .build();
        researcherService.save(researcher);
        researcher = Researcher.builder().firstName("Karen").lastName("Waltorp")
                .title("Associate Professor - Promotion Programme").telephone("").email("karen.waltorp@anthro.ku.dk")
                .profileImage(Image.builder().caption("KarenWaltorp").url("https://www2.adm.ku.dk/selv/pls/prt_www40.hentindhold_cms?p_personid=205546").build())
                .profile("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en/persons/205546")
                .cv("")
                .publications("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Fkaren-waltorp(283176d6-0285-4eb4-9ffc-74e3a837e6e2)%2Fpublications.html")
                .build();
        researcherService.save(researcher);
        researcher = Researcher.builder().firstName("Kristiane").lastName("Fogh")
                .title("Research Assistant").telephone("").email("kf@anthro.ku.dk")
                .profileImage(Image.builder().caption("KristianeFogh").url("").build())
                .profile("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en/persons/520301")
                .cv("")
                .publications("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Fkristiane-fogh(42c00c47-2ff6-486d-9a84-c38cdc8c1445)%2Fpublications.html")
                .build();
        researcherService.save(researcher);
        researcher = Researcher.builder().firstName("Martin").lastName("Lundsteen")
                .title("Postdoc").telephone("+4535327666").email("malu@anthro.ku.dk")
                .profileImage(Image.builder().caption("MartinLundsteen").url("").build())
                .profile("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en/persons/333907")
                .cv("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Fmartin-lundsteen(2ce8a94f-1882-4e8b-b872-143639b385ce)%2Fcv.html")
                .publications("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Fmartin-lundsteen(2ce8a94f-1882-4e8b-b872-143639b385ce)%2Fpublications.html")
                .build();
        researcherService.save(researcher);
        researcher = Researcher.builder().firstName("Matthew").lastName("Alexander Halkes Carey")
                .title("Associate Professor").telephone("+4535321579").email("matthew.carey@anthro.ku.dk")
                .profileImage(Image.builder().caption("MatthewCarey").url("").build())
                .profile("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en/persons/402252")
                .cv("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Fmatthew-alexander-halkes-carey(ade97f77-e6f4-42ba-8b93-f76064f67bcd)%2Fcv.html")
                .publications("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Fmatthew-alexander-halkes-carey(ade97f77-e6f4-42ba-8b93-f76064f67bcd)%2Fpublications.html")
                .build();
        researcherService.save(researcher);
        researcher = Researcher.builder().firstName("Oscar").lastName("Salemink")
                .title("Professor").telephone("+4535324472").email("o.salemink@anthro.ku.dk")
                .profileImage(Image.builder().caption("OscarSalemink").url("https://www2.adm.ku.dk/selv/pls/prt_www40.hentindhold_cms?p_personid=403491").build())
                .profile("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en/persons/403491")
                .cv("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Foscar-salemink(933d0cc6-90d7-42af-bae0-c1cdfc180f5e)%2Fcv.html")
                .publications("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Foscar-salemink(933d0cc6-90d7-42af-bae0-c1cdfc180f5e)%2Fpublications.html")
                .build();
        researcherService.save(researcher);
        researcher = Researcher.builder().firstName("Petya").lastName("Mitkova Koleva")
                .title("PhD Fellow").telephone("").email("pmk@anthro.ku.dk")
                .profileImage(Image.builder().caption("PetyaMitkova").url("").build())
                .profile("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en/persons/487465")
                .cv("")
                .publications("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Fpetya-mitkova-koleva(89bf452d-fccb-4849-a652-35096d031490)%2Fpublications.html")
                .build();
        researcherService.save(researcher);
        researcher = Researcher.builder().firstName("Stine").lastName("Krøijer")
                .title("Associate Professor").telephone("+4535321581").email("stine.kroijer@anthro.ku.dk")
                .profileImage(Image.builder().caption("StineKrojer").url("").build())
                .profile("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en/persons/5036")
                .cv("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Fstine-kroeijer(801c0875-033d-47ed-b815-1663331a64f0)%2Fcv.html")
                .publications("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Fstine-kroeijer(801c0875-033d-47ed-b815-1663331a64f0)%2Fpublications.html")
                .build();
        researcherService.save(researcher);
        researcher = Researcher.builder().firstName("Trine").lastName("Mygind Korsby")
                .title("Assistant professor").telephone("+4535323481").email("trine.korsby@anthro.ku.dk")
                .profileImage(Image.builder().caption("TrineKrosby").url("https://www2.adm.ku.dk/selv/pls/prt_www40.hentindhold_cms?p_personid=205768").build())
                .profile("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en/persons/205768")
                .cv("")
                .publications("https://anthropology.ku.dk/research/researchgroups/culture-mobility-and-power/?pure=en%2Fpersons%2Ftrine-mygind-korsby(423e9c08-05a4-467c-89af-85af824a116e)%2Fpublications.html")
                .build();
        researcherService.save(researcher);
    }
    @Test
    void iExternalResearcher() {
        externalResearcher = ExternalResearcher.builder().firstName("Adrienne").lastName("Mannov")
                .title("Postdoc, Department of Culture and Learning, Aalborg University")
                .profileImage(Image.builder().caption("AdranneMannov").url("").build()).profileLink("").email("").build();
        externalResearcherService.create(externalResearcher);
        externalResearcher = ExternalResearcher.builder().firstName("Henrik").lastName("Hvenegaard Mikkelsen")
                .title("Associated Advisor")
                .profileImage(Image.builder().caption("HenrikHvenegaardMikkelsen").url("").build()).profileLink("").email("").build();
        externalResearcherService.create(externalResearcher);
        externalResearcher = ExternalResearcher.builder().firstName("Susanne").lastName("Bregnbæk")
                .title("Associate Professor")
                .profileImage(Image.builder().caption("Susanne").url("https://www.ucviden.dk/files-asset/103050009/Susanne_Bregnb_c3_a6k_20Web.jpg?w=160&f=webp").build())
                .profileLink("https://www.ucviden.dk/en/persons/susanne-bregnb%C3%A6k").email("").build();
        externalResearcherService.create(externalResearcher);
    }
    @Test
    void iLocation() {
        location = Location.builder().address("Øster Farimagsgade 5 DK-1353 Copenhagen K").build();
        locationService.create(location);
    }


}
