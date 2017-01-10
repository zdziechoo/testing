package transition.technologies.unittesting.basic.collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.Assert.fail;
import static transition.technologies.unittesting.basic.collections.FellowTestFixture.aragorn;
import static transition.technologies.unittesting.basic.collections.FellowTestFixture.boromir;
import static transition.technologies.unittesting.basic.collections.FellowTestFixture.frodo;
import static transition.technologies.unittesting.basic.collections.FellowTestFixture.gandalf;
import static transition.technologies.unittesting.basic.collections.FellowTestFixture.gimli;
import static transition.technologies.unittesting.basic.collections.FellowTestFixture.legolas;
import static transition.technologies.unittesting.basic.collections.FellowTestFixture.merry;
import static transition.technologies.unittesting.basic.collections.FellowTestFixture.pippin;
import static transition.technologies.unittesting.basic.collections.FellowTestFixture.sam;
import static transition.technologies.unittesting.basic.collections.FellowTestFixture.sauron;

import org.junit.Assert;
import org.junit.Test;

public class FellowshipAssertionTest {

    private Fellowship fellowship = formTheFellowshipOfTheRing();


    @Test
    public void frodoShouldBeIn() {

        assertThat(fellowship).contains(frodo());
    }

    @Test
    public void sauronShouldNotBeIn() {
    	assertThat(fellowship).doesNotContain(sauron());
    }
    
    @Test
	public void shouldFrodoNameBeCorrectAndNotBeASauronAndBeInFellowship() {
        assertThat(frodo().getName()).isEqualTo("Frodo").isNotEqualTo("Sauron");
        assertThat(fellowship).contains(frodo());
        }

    @Test
    public void aragornShouldBeBeforeBoromir() {
        assertThat(fellowship.iterator()).containsSequence(aragorn(),boromir());
    }

    @Test
    public void shouldNotContainDuplicatedFellows() {
        //fail("Not yet implemented");
        assertThat(fellowship).doesNotHaveDuplicates();
    }

    @Test
    public void shouldContainOnlyFellowsWithExpectedNamesInProperOrder() {

        assertThat(fellowship).usingDefaultComparator();
    }

    @Test
    public void shouldContainNineFellowsButNoneGiant() {
    	//fail("Not yet implemented");
        assertThat(fellowship).hasSize(9);
    	//assertThat(fellowship).hasSize(9).doesNotContain("Giant");
    }
    
    @Test
	public void shouldContainTupleForBoromirSamAndLegolas() {
        // Extracting multiple values at once (using tuple to group them)
        // Create tuples with name and race name
    	/*assertThat(fellowship).extracting(Fellow::getName,Fellow::getRace).
                contains(
                        tuple(boromir().getName(),sam().getRace(),
                        tuple(boromir().getName(),legolas().getRace()),
                        tuple(sam().getName(),legolas().getRace())));
	}*/
        fail("Not yet implemented");
    }
    @Test
	public void shouldContaintFourHobbits() {
        assertThat(fellowship.hobbits()).hasSize(4);
	}


    private Fellowship formTheFellowshipOfTheRing() {
        return new Fellowship(
                frodo(),
                sam(),
                merry(),
                pippin(),
                gandalf(),
                legolas(),
                gimli(),
                aragorn(),
                boromir());
    }
}
