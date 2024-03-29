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
    @Autowired
    ResearcherService researcherService;
    @Autowired
    ExternalResearcherService externalResearcherService;
    @Autowired
    LocationService locationService;
    @Autowired
    RoomService roomService;
    @Autowired
    EventService eventService;
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
        externalResearcher = ExternalResearcher.builder().firstName("Irene").lastName("Stengs")
                .title("Prof., Dr.")
                .profileImage(Image.builder().caption("IreneStengs").url("").build())
                .profileLink("https://research.vu.nl/en/persons/irene-stengs").email("i.l.stengs@vu.nl").build();
        externalResearcherService.create(externalResearcher);
        externalResearcher = ExternalResearcher.builder().firstName("Mikkel").lastName("Bille")
                .title("Professor")
                .profileImage(Image.builder().caption("MikkelBille").url("https://www2.adm.ku.dk/selv/pls/prt_www40.hentindhold_cms?p_personid=179827").build())
                .profileLink("https://saxoinstitute.ku.dk/staff/?pure=en%2Fpersons%2Fmikkel-bille(ba59254a-5bab-46e5-b326-4eb9eb90b68c)%2Fkeywords.html").email("mbille@hum.ku.dk").build();
        externalResearcherService.create(externalResearcher);
    }

    @Test
    @Order(3)
    void iLocationRoom() {
        location = Location.builder().address("Øster Farimagsgade 5 DK-1353 Copenhagen K").build();
        locationService.create(location);
        room = Room.builder().location(location).name("33.1.18 - The Faculty of Social Sciences").capacity("20").build();
        roomService.create(room);
        room = Room.builder().location(location).name("CSS 4.1.12 - Ethnographic Exploratory").capacity("20").build();
        roomService.create(room);

        location = Location.builder().address("Royal Street 100. 5000 GreatCity").build();
        locationService.create(location);
        room = Room.builder().location(location).name("9.9.99 - GreatRoom").capacity("200").build();
        roomService.create(room);
    }

    @Test
    @Order(4)
    void iEvent() throws ResearcherNotFoundException, ExternalResearcherNotFoundException, SectionsSequenceException {

        //event1
        paragraphSection = ParagraphSection.builder()
                .seq(1).heading("")
                .text("The Centre for Global Criminology is hosting a seminar on \"Spying, surveillance and the ethnographic method\". " +
                        "A thematically and geographically wide range of papers will be presented and we look forward to lively discussion o\n" +
                        "n the topic.\n" +
                        "The seminar is open to a limited audience, but if you're interested, please sign up!").build();
        paragraphSectionSet.add(paragraphSection);
        paragraphSection = ParagraphSection.builder()
                .seq(2).heading("")
                .text("More information - email Asbjørn: asbjorngm@anthro.ku.dk").build();
        paragraphSectionSet.add(paragraphSection);

        linkSection = LinkSection.builder()
                .seq(3).text("Programme").link("https://ccc.ku.dk/calendar/upcoming-events/research-seminar---the-hall-of-mirrors-spying-surveillance-and-ethnographic-method/Program__The_Hall_of_Mirrors_seminar-1.png_copy").build();
        linkSectionSet.add(linkSection);

        researcherSet.add(researcherService.getById(14L));
        researcherSet.add(researcherService.getById(18L));

        event = Event.builder()
                .name("The Hall of Mirrors: Spying, surveillance, and ethnographic method - Research Seminar")
                .date(LocalDate.of(2023, 12, 2))
                .startTime(LocalTime.of(9, 30, 0))
                .endTime(LocalTime.of(17, 30, 0))
                .image(Image.builder().caption("The Hall of Mirrors").url("https://i.imgur.com/CH78lV8.png").build())
                .researcherSet(researcherSet)
                .externalResearcherSet(externalResearcherSet)
                .paragraphSectionSet(paragraphSectionSet)
                .linkSectionSet(linkSectionSet)
                .imageSectionSet(imageSectionSet)
                .room(roomService.getById(2L))
                .build();
        eventService.create(event);

        //event2
        //reset the sets
        researcherSet = new HashSet<>();
        externalResearcherSet = new HashSet<>();
        paragraphSectionSet = new HashSet<>();
        imageSectionSet = new HashSet<>();
        linkSectionSet = new HashSet<>();

        paragraphSection = ParagraphSection.builder()
                .seq(1).heading("")
                .text("Irene Stengs - Prof., Dr., editor and senior researcher of Meertens Institutt, Vrije Universiteet Amsterdam").build();
        paragraphSectionSet.add(paragraphSection);
        paragraphSection = ParagraphSection.builder()
                .seq(2).heading("")
                .text("Oscar Salemink - Editor, Professor of Anthropology, University of Copenhagen").build();
        paragraphSectionSet.add(paragraphSection);
        paragraphSection = ParagraphSection.builder()
                .seq(3).heading("")
                .text("In conversation with Mikkel Bille - Professor of Saxo Institute, University of Copenhagen").build();
        paragraphSectionSet.add(paragraphSection);
        paragraphSection = ParagraphSection.builder()
                .seq(4).heading("")
                .text("Book launch: Managing Sacralities").build();
        paragraphSectionSet.add(paragraphSection);
        imageSection = ImageSection.builder().seq(5).image(Image.builder().url("https://i.imgur.com/DSXZkGt.png").caption("Managing Sacralities").build()).altText("Managing Sacralities").build();
        imageSectionSet.add(imageSection);
        researcherSet.add(researcherService.getById(15L));
        externalResearcherSet.add(externalResearcherService.getById(6L));
        externalResearcherSet.add(externalResearcherService.getById(7L));


        event = Event.builder()
                .name("Ethnographic Happy Hour, Book Launch: Managing Sacralities")
                .date(LocalDate.of(2023, 11, 2))
                .startTime(LocalTime.of(15, 30, 0))
                .endTime(LocalTime.of(17, 0, 0))
                .image(Image.builder().caption("Managing Sacralities").url("https://i.imgur.com/GOud8dd.png").build())
                .researcherSet(researcherSet)
                .externalResearcherSet(externalResearcherSet)
                .paragraphSectionSet(paragraphSectionSet)
                .linkSectionSet(linkSectionSet)
                .imageSectionSet(imageSectionSet)
                .room(roomService.getById(2L))
                .build();
        eventService.create(event);

        //event3
        //reset the sets
        researcherSet = new HashSet<>();
        externalResearcherSet = new HashSet<>();
        paragraphSectionSet = new HashSet<>();
        imageSectionSet = new HashSet<>();
        linkSectionSet = new HashSet<>();

        paragraphSection = ParagraphSection.builder()
                .seq(1).heading("Abstract")
                .text("Bureaucracy runs the lives of mothers of modest means. It brings up a whole host of medical or epidemiological " +
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
        paragraphSection = ParagraphSection.builder()
                .seq(4).heading("Anja Simonsen, Department of Anthropology")
                .text("anja.simonsen@anthro.ku.dk").build();
        paragraphSectionSet.add(paragraphSection);
        paragraphSection = ParagraphSection.builder()
                .seq(5).heading("Atreyee Sen, Department of Anthropology")
                .text("atreyee.sen@anthro.ku.dk").build();
        paragraphSectionSet.add(paragraphSection);
        paragraphSection = ParagraphSection.builder()
                .seq(6).heading("Liora Sion, Department of CrossCultural and Regional Studies")
                .text("liorasion@hum.ku.dk").build();
        paragraphSectionSet.add(paragraphSection);

        researcherSet.add(researcherService.getById(1L));
        researcherSet.add(researcherService.getById(3L));
        externalResearcherSet.add(externalResearcherService.getById(4L));


        event = Event.builder()
                .name("Single Mothers, Bureaucratic Torture, and the Neoliberal Welfare State")
                .date(LocalDate.of(2023, 11, 25))
                .startTime(LocalTime.of(13, 0, 0))
                .endTime(LocalTime.of(15, 0, 0))
                .image(Image.builder().caption("Single Mothers, Bureaucratic Torture, and Neoliberal Welfare State").url("").build())
                .researcherSet(researcherSet)
                .externalResearcherSet(externalResearcherSet)
                .paragraphSectionSet(paragraphSectionSet)
                .linkSectionSet(linkSectionSet)
                .imageSectionSet(imageSectionSet)
                .room(roomService.getById(1L))
                .build();
        eventService.create(event);

        //event4
        //reset the sets
        researcherSet = new HashSet<>();
        externalResearcherSet = new HashSet<>();
        paragraphSectionSet = new HashSet<>();
        imageSectionSet = new HashSet<>();
        linkSectionSet = new HashSet<>();

        paragraphSection = ParagraphSection.builder()
                .seq(1).heading("")
                .text("This conference aims to explore the relationship between anthropology and history, and how the two disciplines can " +
                        "inform and enrich each other. Sessions will cover topics such as cultural heritage, archaeology, and the use of oral histories.\n").build();
        paragraphSectionSet.add(paragraphSection);
        paragraphSection = ParagraphSection.builder()
                .seq(2).heading("")
                .text("Anthropology and history are two fields that have long been intertwined, each offering unique insights into the past " +
                        "and present of human societies. The Bridging the Past and Present conference seeks to build upon this interdisciplinary " +
                        "relationship by bringing together scholars and researchers from both fields to discuss the intersection of anthropology and history.\n" +
                        "The conference will feature a wide range of topics, from the role of archaeology in understanding ancient civilizations, " +
                        "to the ways in which oral histories can shed light on marginalized communities. Presenters will also explore the ways in which " +
                        "history can inform contemporary issues, such as the impact of colonialism on modern-day societies, and the legacy of slavery and racism in Denmark.\n").build();
        paragraphSectionSet.add(paragraphSection);

        researcherSet.add(researcherService.getById(6L));
        researcherSet.add(researcherService.getById(10L));
        externalResearcherSet.add(externalResearcherService.getById(2L));
        externalResearcherSet.add(externalResearcherService.getById(5L));


        event = Event.builder()
                .name("Bridging the Past and Present: An Interdisciplinary Conference on Anthropology and History")
                .date(LocalDate.of(2023, 11, 26))
                .startTime(LocalTime.of(13, 0, 0))
                .endTime(LocalTime.of(15, 0, 0))
                .image(Image.builder().caption("Bridging the Past and Present: An Interdisciplinary Conference on Anthropology and History")
                        .url("https://images.unsplash.com/photo-1591622180684-b96c52ef3908?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80")
                        .build())
                .researcherSet(researcherSet)
                .externalResearcherSet(externalResearcherSet)
                .paragraphSectionSet(paragraphSectionSet)
                .linkSectionSet(linkSectionSet)
                .imageSectionSet(imageSectionSet)
                .room(roomService.getById(3L))
                .build();
        eventService.create(event);

        //event5
        //reset the sets
        researcherSet = new HashSet<>();
        externalResearcherSet = new HashSet<>();
        paragraphSectionSet = new HashSet<>();
        imageSectionSet = new HashSet<>();
        linkSectionSet = new HashSet<>();

        paragraphSection = ParagraphSection.builder()
                .seq(1).heading("")
                .text("The conference will take place over several days and will include a mix of keynote addresses, panel discussions," +
                        " and workshops. Participants will have the opportunity to engage with presenters, ask questions, and share their own insights and perspectives.\n").build();
        paragraphSectionSet.add(paragraphSection);
        paragraphSection = ParagraphSection.builder()
                .seq(2).heading("")
                .text("Overall, the Bridging the Past and Present conference promises to be an exciting and thought-provoking" +
                        " event for scholars and researchers in the fields of anthropology and history. By exploring the intersections" +
                        " between these two fields, the conference seeks to deepen our understanding of the past and present of human societies, " +
                        "and to inspire new approaches to the challenges we face today.\n").build();
        paragraphSectionSet.add(paragraphSection);

        researcherSet.add(researcherService.getById(6L));
        researcherSet.add(researcherService.getById(10L));
        externalResearcherSet.add(externalResearcherService.getById(2L));
        externalResearcherSet.add(externalResearcherService.getById(5L));

        event = Event.builder()
                .name("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore")
                .date(LocalDate.of(2023, 3, 25))
                .startTime(LocalTime.of(13, 0, 0))
                .endTime(LocalTime.of(15, 0, 0))
                .image(Image.builder().caption("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore")
                        .url("https://images.unsplash.com/photo-1597711168028-6ebe67f9aa0a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1171&q=80")
                        .build())
                .researcherSet(researcherSet)
                .externalResearcherSet(externalResearcherSet)
                .paragraphSectionSet(paragraphSectionSet)
                .linkSectionSet(linkSectionSet)
                .imageSectionSet(imageSectionSet)
                .room(roomService.getById(3L))
                .build();
        eventService.create(event);

        //event6
        //reset the sets
        researcherSet = new HashSet<>();
        externalResearcherSet = new HashSet<>();
        paragraphSectionSet = new HashSet<>();
        imageSectionSet = new HashSet<>();
        linkSectionSet = new HashSet<>();

        paragraphSection = ParagraphSection.builder()
                .seq(1).heading("")
                .text("The conference will take place over several days and will include a mix of keynote addresses, panel discussions," +
                        " and workshops. Participants will have the opportunity to engage with presenters, ask questions, and share their own insights and perspectives.\n").build();
        paragraphSectionSet.add(paragraphSection);
        paragraphSection = ParagraphSection.builder()
                .seq(2).heading("")
                .text("Overall, the Bridging the Past and Present conference promises to be an exciting and thought-provoking" +
                        " event for scholars and researchers in the fields of anthropology and history. By exploring the intersections" +
                        " between these two fields, the conference seeks to deepen our understanding of the past and present of human societies, " +
                        "and to inspire new approaches to the challenges we face today.\n").build();
        paragraphSectionSet.add(paragraphSection);

        researcherSet.add(researcherService.getById(6L));
        researcherSet.add(researcherService.getById(10L));
        externalResearcherSet.add(externalResearcherService.getById(2L));
        externalResearcherSet.add(externalResearcherService.getById(5L));


        event = Event.builder()
                .name("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore")
                .date(LocalDate.of(2022, 3, 25))
                .startTime(LocalTime.of(13, 0, 0))
                .endTime(LocalTime.of(15, 0, 0))
                .image(Image.builder().caption("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore")
                        .url("https://images.unsplash.com/photo-1528642474498-1af0c17fd8c3?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1769&q=80")
                        .build())
                .researcherSet(researcherSet)
                .externalResearcherSet(externalResearcherSet)
                .paragraphSectionSet(paragraphSectionSet)
                .linkSectionSet(linkSectionSet)
                .imageSectionSet(imageSectionSet)
                .room(roomService.getById(3L))
                .build();
        eventService.create(event);

        //event7
        //reset the sets
        researcherSet = new HashSet<>();
        externalResearcherSet = new HashSet<>();
        paragraphSectionSet = new HashSet<>();
        imageSectionSet = new HashSet<>();
        linkSectionSet = new HashSet<>();

        paragraphSection = ParagraphSection.builder()
                .seq(1).heading("")
                .text("This symposium brings together experts from different fields of anthropology to discuss the unique " +
                        "cultures and ways of life found around the world. Topics will include language, music, religion, art, and more.\n").build();
        paragraphSectionSet.add(paragraphSection);
        paragraphSection = ParagraphSection.builder()
                .seq(2).heading("")
                .text("Culture is a complex and multifaceted concept that is central to anthropology, the study of human societies and cultures. " +
                        "Cultures are defined by shared beliefs, customs, practices, and values, and vary widely across the world. Anthropology " +
                        "seeks to understand and appreciate this cultural diversity, and the \"Exploring the Diverse Cultures of the World: An " +
                        "Anthropological Symposium\" event celebrates this goal.\n").build();
        paragraphSectionSet.add(paragraphSection);
        paragraphSection = ParagraphSection.builder()
                .seq(4).heading("")
                .text("One of the key aims of the symposium is to highlight the value of anthropology in helping us better understand and appreciate " +
                        "the diversity of cultures across the world. Anthropologists use a range of methods and techniques to study cultures, including" +
                        " participant observation, interviews, and archival research. Through these methods, they gain insights into the intricacies of " +
                        "cultural practices and beliefs, and how these relate to broader social, economic, and political factors.\n").build();
        paragraphSectionSet.add(paragraphSection);
        imageSection = ImageSection.builder().seq(3).image(Image.builder().url("http://people-project.net/wp-content/uploads/2019/12/cytrynowicz_r-5M1A5055.jpg")
                .caption("Exploring Diversity").build()).altText("Exploring Diversity").build();
        imageSectionSet.add(imageSection);

        researcherSet.add(researcherService.getById(6L));
        researcherSet.add(researcherService.getById(10L));
        externalResearcherSet.add(externalResearcherService.getById(2L));
        externalResearcherSet.add(externalResearcherService.getById(5L));


        event = Event.builder()
                .name("Exploring the Diverse Cultures of the World: An Anthropological Symposium")
                .date(LocalDate.of(2023, 4, 25))
                .startTime(LocalTime.of(13, 0, 0))
                .endTime(LocalTime.of(15, 0, 0))
                .image(Image.builder().caption("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore")
                        .url("https://images.unsplash.com/photo-1556484687-30636164638b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1074&q=80")
                        .build())
                .researcherSet(researcherSet)
                .externalResearcherSet(externalResearcherSet)
                .paragraphSectionSet(paragraphSectionSet)
                .linkSectionSet(linkSectionSet)
                .imageSectionSet(imageSectionSet)
                .room(roomService.getById(3L))
                .build();
        eventService.create(event);

        //event8
        //reset the sets
        researcherSet = new HashSet<>();
        externalResearcherSet = new HashSet<>();
        paragraphSectionSet = new HashSet<>();
        imageSectionSet = new HashSet<>();
        linkSectionSet = new HashSet<>();

        paragraphSection = ParagraphSection.builder()
                .seq(1).heading("")
                .text("This symposium brings together experts from different fields of anthropology to discuss the unique " +
                        "cultures and ways of life found around the world. Topics will include language, music, religion, art, and more.\n").build();
        paragraphSectionSet.add(paragraphSection);
        paragraphSection = ParagraphSection.builder()
                .seq(2).heading("")
                .text("Culture is a complex and multifaceted concept that is central to anthropology, the study of human societies and cultures. " +
                        "Cultures are defined by shared beliefs, customs, practices, and values, and vary widely across the world. Anthropology " +
                        "seeks to understand and appreciate this cultural diversity, and the \"Exploring the Diverse Cultures of the World: An " +
                        "Anthropological Symposium\" event celebrates this goal.\n").build();
        paragraphSectionSet.add(paragraphSection);
        paragraphSection = ParagraphSection.builder()
                .seq(4).heading("")
                .text("One of the key aims of the symposium is to highlight the value of anthropology in helping us better understand and appreciate " +
                        "the diversity of cultures across the world. Anthropologists use a range of methods and techniques to study cultures, including" +
                        " participant observation, interviews, and archival research. Through these methods, they gain insights into the intricacies of " +
                        "cultural practices and beliefs, and how these relate to broader social, economic, and political factors.\n").build();
        paragraphSectionSet.add(paragraphSection);
        imageSection = ImageSection.builder().seq(3).image(Image.builder().url("http://people-project.net/wp-content/uploads/2019/12/cytrynowicz_r-5M1A5055.jpg")
                .caption("Exploring Diversity").build()).altText("Exploring Diversity").build();
        imageSectionSet.add(imageSection);

        researcherSet.add(researcherService.getById(6L));
        researcherSet.add(researcherService.getById(10L));
        externalResearcherSet.add(externalResearcherService.getById(2L));
        externalResearcherSet.add(externalResearcherService.getById(5L));


        event = Event.builder()
                .name("Exploring the Diverse Cultures of the World: An Anthropological Symposium")
                .date(LocalDate.of(2022, 4, 25))
                .startTime(LocalTime.of(13, 0, 0))
                .endTime(LocalTime.of(15, 0, 0))
                .image(Image.builder().caption("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore")
                        .url("https://images.unsplash.com/photo-1520880867055-1e30d1cb001c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80")
                        .build())
                .researcherSet(researcherSet)
                .externalResearcherSet(externalResearcherSet)
                .paragraphSectionSet(paragraphSectionSet)
                .linkSectionSet(linkSectionSet)
                .imageSectionSet(imageSectionSet)
                .room(roomService.getById(3L))
                .build();
        eventService.create(event);


    }
}
