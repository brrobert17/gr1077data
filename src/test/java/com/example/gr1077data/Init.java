package com.example.gr1077data;

import com.example.gr1077data.model.*;
import com.example.gr1077data.service.*;
import com.example.gr1077data.service.exception.ExternalResearcherNotFoundException;
import com.example.gr1077data.service.exception.ResearcherNotFoundException;
import com.example.gr1077data.service.exception.RoomNotFoundException;
import com.example.gr1077data.service.exception.SectionsSequenceException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Init {
    @Autowired ResearcherService researcherService;
    @Autowired ExternalResearcherService externalResearcherService;
    @Autowired LocationService locationService;
    @Autowired RoomService roomService;
    @Autowired EventService eventService;
    Researcher researcher;
    ExternalResearcher externalResearcher;
    Location location;
    Room room;
    Event event;
    ParagraphSection paragraphSection;
    LinkSection linkSection;
    ImageSection imageSection;
    Set<Researcher> researcherSet = new HashSet<>();
    Set<ExternalResearcher> externalResearcherSet = new HashSet<>();
    Set<ParagraphSection> paragraphSectionSet = new HashSet<>();
    Set<ImageSection> imageSectionSet = new HashSet<>();
    Set<LinkSection> linkSectionSet = new HashSet<>();

    @Test
    @Order(1)
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
    @Order(2)
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
        externalResearcher = ExternalResearcher.builder().firstName("Liora").lastName("Sion")
                .title("Associate Professor")
                .profileImage(Image.builder().caption("Liora").url("https://www2.adm.ku.dk/selv/pls/prt_www40.hentindhold_cms?p_personid=644193").build())
                .profileLink("https://ccrs.ku.dk/staff/?pure=en%2Fpersons%2Fliora-sion(d403e802-546b-49b4-822a-246a3a424bc8).html").email("liorasion@hum.ku.dk").build();
        externalResearcherService.create(externalResearcher);
        externalResearcher = ExternalResearcher.builder().firstName("Matthew").lastName("Carey")
                .title("")
                .profileImage(Image.builder().caption("MatthewCarey").url("").build())
                .profileLink("").email("").build();
        externalResearcherService.create(externalResearcher);
    }
    @Test
    @Order(3)
    void iLocation() {
        location = Location.builder().address("Øster Farimagsgade 5 DK-1353 Copenhagen K").build();
        locationService.create(location);
    }

    @Test
    @Order(4)
    void iRoom() {
        room = Room.builder().location(location).name("33.1.18 - The Faculty of Social Sciences").capacity("20").build();
        roomService.create(room);
        room = Room.builder().location(location).name("CSS 4.1.12 - Ethnographic Exploratory").capacity("20").build();
        roomService.create(room);
    }

    @Test
    @Order(5)
    void iEvent() throws ResearcherNotFoundException, ExternalResearcherNotFoundException, SectionsSequenceException {
        paragraphSection = ParagraphSection.builder()
                .seq(1).heading("")
                .text("Abstract: Bureaucracy runs the lives of mothers of modest means. It brings up a whole host of medical or epidemiological " +
                        "problems, because it has a cumulative effect on mothers' bodies in the Global South or when they migrate north. " +
                        "For a woman to reclaim her rights through bureaucracy, at times she needs to volunteer her body as a sexual tool. " +
                        "The clerks are often male, and the clients are impoverished, disempowered women. Bureaucracy is a topic that has been " +
                        "neglected by feminists because it is not as reassuring as agency and resistance studies.").build();
        paragraphSectionSet.add(paragraphSection);
        paragraphSection = ParagraphSection.builder()
                .seq(2).heading("")
                .text("In my presentation I will focus on the phenomenological embodiments of Mizrahi single mothers' untold entanglements in " +
                        "Israel's welfare bureaucracies. While Jews of non-European origins are the demographic majority of Israel and therefore " +
                        "are subject to structural and day-to-day racism, Israel's elaborate welfare bureaucracy conceives of itself as " +
                        "race-neutral. So the mothers' entanglements in the welfare system's webs rarely depart from their pre-discursive state " +
                        "to become discourse leading to mimetic redemption and agential action.").build();
        paragraphSectionSet.add(paragraphSection);
        paragraphSection = ParagraphSection.builder()
                .seq(3).heading("")
                .text("Postcolonial or decolonial ethnographies stress thinking in hybridities and multiplicities—the intersection of race, gender, " +
                        "sex, class, and religion into the agency of identity politics. But Israel's bureaucratic regime is based on the " +
                        "essentialist sanctity of the state, and therefore Mizrahi single mothers cannot enact intersectionality. Contrarily, " +
                        "they must align with the monothetic logic of an ethno-religious state bureaucracy to survive the welfare system they " +
                        "and their children depend on. The mothers deny the interplay between the traumas of theirs and their parents' " +
                        "orchestrated migration-dislocation-de-Arabization and the expulsion of the Palestinians in order to make room for" +
                        " the Israeli state. Instead, they brandish right-wing ultranationalist politics. Yet the bureaucratic torture they " +
                        "live through haunts them and is transmitted from one generation the next.").build();
        paragraphSectionSet.add(paragraphSection);

        linkSection = LinkSection.builder()
                .seq(4).text("Anja Simonsen, Department of Anthropology").link("anja.simonsen@anthro.ku.dk").build();
        linkSectionSet.add(linkSection);
        linkSection = LinkSection.builder()
                .seq(5).text("Atreyee Sen, Department of Anthropology").link("atreyee.sen@anthro.ku.dk").build();
        linkSectionSet.add(linkSection);linkSection = LinkSection.builder()
                .seq(6).text("Liora Sion, Department of CrossCultural and Regional Studies").link("liorasion@hum.ku.dk").build();
        linkSectionSet.add(linkSection);

        researcherSet.add(researcherService.getById(1L));
        researcherSet.add(researcherService.getById(3L));
        externalResearcherSet.add(externalResearcherService.getById(4L));


        event = Event.builder()
                .name("Single Mothers, Bureaucratic Torture, and the Neoliberal Welfare State")
                .date(LocalDate.of(2023,11,25))
                .startTime(LocalTime.of(13,0,0))
                .endTime(LocalTime.of(15,0,0))
                .image(Image.builder().caption("SingleMothersBureaucraticTorture").url("").build())
                .researcherSet(researcherSet)
                .externalResearcherSet(externalResearcherSet)
                .paragraphSectionSet(paragraphSectionSet)
                .linkSectionSet(linkSectionSet)
                .imageSectionSet(imageSectionSet)
                .room(roomService.getById(1L))
                .build();
        eventService.create(event);

        //reset the sets
        researcherSet = new HashSet<>();
        externalResearcherSet = new HashSet<>();
        paragraphSectionSet = new HashSet<>();
        imageSectionSet = new HashSet<>();
        linkSectionSet = new HashSet<>();

        paragraphSection = ParagraphSection.builder()
                .seq(1).heading("")
                .text("The Centre for Global Criminology is hosting a seminar on \"Spying, surveillance and the ethnographic method\". " +
                        "A thematically and geographically wide range of papers will be presented and we look forward to lively discussion o\n" +
                        "n the topic.\n" +
                        "The seminar is open to a limited audience, but if you're interested, please sign up!").build();
        paragraphSectionSet.add(paragraphSection);

        linkSection = LinkSection.builder()
                .seq(4).text("More information - email Asbjørn").link("asbjorngm@anthro.ku.dk").build();
        linkSectionSet.add(linkSection);
        linkSection = LinkSection.builder()
                .seq(5).text("Programme:").link("https://ccc.ku.dk/calendar/upcoming-events/research-seminar---the-hall-of-mirrors-spying-surveillance-and-ethnographic-method/Program__The_Hall_of_Mirrors_seminar-1.png_copy").build();
        linkSectionSet.add(linkSection);


        researcherSet.add(researcherService.getById(14L));
        researcherSet.add(researcherService.getById(18L));


        event = Event.builder()
                .name("The Hall of Mirrors: Spying, surveillance, and ethnographic method - Research Seminar")
                .date(LocalDate.of(2023,12,2))
                .startTime(LocalTime.of(9,30,0))
                .endTime(LocalTime.of(17,30,0))
                .image(Image.builder().caption("the_hall_of_mirrors").url("https://i.imgur.com/CH78lV8.png").build())
                .researcherSet(researcherSet)
                .externalResearcherSet(externalResearcherSet)
                .paragraphSectionSet(paragraphSectionSet)
                .linkSectionSet(linkSectionSet)
                .imageSectionSet(imageSectionSet)
                .room(roomService.getById(2L))
                .build();
        eventService.create(event);
    }


}
