import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicDoubleLinkedList_STUDENT_TEST{

    BasicDoubleLinkedList<MusicVideo> LabelMusicPortfolio;
    MusicVideoComparator comparator;

    public MusicVideo MusicVideo1 = new MusicVideo("Beyonce", "Crazy in Love", 2000);
    public MusicVideo MusicVideo2 = new MusicVideo("Megan", "Cry baby", 2020);
    public MusicVideo MusicVideo3 = new MusicVideo("Doja Cat", "woman", 1920);
    public MusicVideo MusicVideo4 = new MusicVideo("Ismael Lo", "Jammu Africa", 1996);
    public MusicVideo MusicVideo5 = new MusicVideo("Youssou Ndour ", "Seven seconds", 1999);


    @Before
    public void setUp() throws Exception {
        LabelMusicPortfolio = new BasicDoubleLinkedList<MusicVideo>();
        LabelMusicPortfolio.addToEnd(MusicVideo2);
        LabelMusicPortfolio.addToEnd(MusicVideo3);
        LabelMusicPortfolio.addToEnd(MusicVideo4);
        comparator = new MusicVideoComparator();
    }

    @After
    public void tearDown() throws Exception {
        LabelMusicPortfolio = null;
        comparator = null;
    }

    @Test
    public void testGetSize() {
        assertEquals(3, LabelMusicPortfolio.getSize());
    }

    @Test
    public void testAddToEnd() {
        assertEquals(MusicVideo4, LabelMusicPortfolio.getLast());
        LabelMusicPortfolio.addToEnd(MusicVideo5);
        assertEquals(MusicVideo5, LabelMusicPortfolio.getLast());
    }

    @Test
    public void testAddToFront() {
        assertEquals(MusicVideo2, LabelMusicPortfolio.getFirst());
        LabelMusicPortfolio.addToFront(MusicVideo1);
        assertEquals(MusicVideo1, LabelMusicPortfolio.getFirst());
    }

    @Test
    public void testGetFirst() {
        assertEquals(MusicVideo2, LabelMusicPortfolio.getFirst());
        LabelMusicPortfolio.addToFront(MusicVideo1);
        assertEquals(MusicVideo1, LabelMusicPortfolio.getFirst());
    }

    @Test
    public void testGetLast() {
        assertEquals(MusicVideo4, LabelMusicPortfolio.getLast());
        LabelMusicPortfolio.addToEnd(MusicVideo5);
        assertEquals(MusicVideo5, LabelMusicPortfolio.getLast());
    }

    @Test
    public void testToArrayList() {
        ArrayList<MusicVideo> list;
        LabelMusicPortfolio.addToFront(MusicVideo1);
        LabelMusicPortfolio.addToEnd(MusicVideo5);
        list = LabelMusicPortfolio.toArrayList();
        assertEquals(MusicVideo1, list.get(0));
        assertEquals(MusicVideo2, list.get(1));
        assertEquals(MusicVideo3, list.get(2));
        assertEquals(MusicVideo4, list.get(3));
        assertEquals(MusicVideo5, list.get(4));
    }

    @Test
    public void testIteratorSuccessfulNext() {

        LabelMusicPortfolio.addToFront(MusicVideo1);
        LabelMusicPortfolio.addToEnd(MusicVideo5);
        ListIterator<MusicVideo> iteratorMusicVideo = LabelMusicPortfolio.iterator();
        assertEquals(true, iteratorMusicVideo.hasNext());
        assertEquals(MusicVideo1, iteratorMusicVideo.next());
        assertEquals(MusicVideo2, iteratorMusicVideo.next());
        assertEquals(MusicVideo3, iteratorMusicVideo.next());
        assertEquals(MusicVideo4, iteratorMusicVideo.next());
        assertEquals(true, iteratorMusicVideo.hasNext());
        assertEquals(MusicVideo5, iteratorMusicVideo.next());
        assertEquals(false, iteratorMusicVideo.hasNext());
    }

    @Test
    public void testIteratorSuccessfulPrevious() {
        LabelMusicPortfolio.addToFront(MusicVideo1);
        LabelMusicPortfolio.addToEnd(MusicVideo5);
        ListIterator<MusicVideo> iteratorMusicVideo = LabelMusicPortfolio.iterator();
        assertEquals(true, iteratorMusicVideo.hasNext());
        assertEquals(MusicVideo1, iteratorMusicVideo.next());
        assertEquals(MusicVideo2, iteratorMusicVideo.next());
        assertEquals(MusicVideo3, iteratorMusicVideo.next());
        assertEquals(MusicVideo4, iteratorMusicVideo.next());
        assertEquals(MusicVideo5, iteratorMusicVideo.next());
        assertEquals(true, iteratorMusicVideo.hasPrevious());
        assertEquals(MusicVideo5, iteratorMusicVideo.previous());
        assertEquals(MusicVideo4, iteratorMusicVideo.previous());
        assertEquals(MusicVideo3, iteratorMusicVideo.previous());
        assertEquals(MusicVideo2, iteratorMusicVideo.previous());
        assertEquals(MusicVideo1, iteratorMusicVideo.previous());
    }

    @Test
    public void testIteratorNoSuchElementExceptionNext() {

        LabelMusicPortfolio.addToFront(MusicVideo1);
        LabelMusicPortfolio.addToEnd(MusicVideo5);
        ListIterator<MusicVideo> iteratorMusicVideo = LabelMusicPortfolio.iterator();
        assertEquals(true, iteratorMusicVideo.hasNext());
        assertEquals(MusicVideo1, iteratorMusicVideo.next());
        assertEquals(MusicVideo2, iteratorMusicVideo.next());
        assertEquals(MusicVideo3, iteratorMusicVideo.next());
        assertEquals(MusicVideo4, iteratorMusicVideo.next());
        assertEquals(true, iteratorMusicVideo.hasNext());
        assertEquals(MusicVideo5, iteratorMusicVideo.next());
        assertEquals(false, iteratorMusicVideo.hasNext());

        try {
            iteratorMusicVideo.next();
            assertTrue("Did not throw a NoSuchElementException", false);
        } catch (NoSuchElementException e) {
            assertTrue("Successfully threw a NoSuchElementException", true);
        } catch (Exception e) {
            assertTrue("Threw an exception other than the NoSuchElementException", false);
        }

    }

    @Test
    public void testIteratorNoSuchElementExceptionPrevious() {
        LabelMusicPortfolio.addToFront(MusicVideo1);
        LabelMusicPortfolio.addToEnd(MusicVideo5);
        ListIterator<MusicVideo> iteratorMusicVideo = LabelMusicPortfolio.iterator();
        assertEquals(true, iteratorMusicVideo.hasNext());
        assertEquals(MusicVideo1, iteratorMusicVideo.next());
        assertEquals(MusicVideo2, iteratorMusicVideo.next());
        assertEquals(MusicVideo3, iteratorMusicVideo.next());
        assertEquals(MusicVideo4, iteratorMusicVideo.next());
        assertEquals(MusicVideo5, iteratorMusicVideo.next());
        assertEquals(true, iteratorMusicVideo.hasPrevious());
        assertEquals(MusicVideo5, iteratorMusicVideo.previous());
        assertEquals(MusicVideo4, iteratorMusicVideo.previous());
        assertEquals(MusicVideo3, iteratorMusicVideo.previous());
        assertEquals(MusicVideo2, iteratorMusicVideo.previous());
        assertEquals(MusicVideo1, iteratorMusicVideo.previous());

        try {
            iteratorMusicVideo.previous();
            assertTrue("Did not throw a NoSuchElementException", false);
        } catch (NoSuchElementException e) {
            assertTrue("Successfully threw a NoSuchElementException", true);
        } catch (Exception e) {
            assertTrue("Threw an exception other than the NoSuchElementException", false);
        }

    }

    @Test
    public void testIteratorUnsupportedOperationException() {
        LabelMusicPortfolio.addToFront(MusicVideo1);
        ListIterator<MusicVideo> iteratorMusicVideo = LabelMusicPortfolio.iterator();
        assertEquals(true, iteratorMusicVideo.hasNext());
        assertEquals(MusicVideo1, iteratorMusicVideo.next());
        assertEquals(MusicVideo2, iteratorMusicVideo.next());

        try {
            iteratorMusicVideo.remove();
            assertTrue("Did not throw a UnsupportedOperationException", false);
        } catch (UnsupportedOperationException e) {
            assertTrue("Successfully threw a UnsupportedOperationException", true);
        } catch (Exception e) {
            assertTrue("Threw an exception other than the UnsupportedOperationException", false);
        }

    }

    @Test
    public void testRemove() {
        assertEquals(3, LabelMusicPortfolio.getSize());
        assertEquals(MusicVideo2, LabelMusicPortfolio.getFirst());
        assertEquals(MusicVideo4, LabelMusicPortfolio.getLast());
        LabelMusicPortfolio.remove(MusicVideo2, comparator);
        assertEquals(2, LabelMusicPortfolio.getSize());
        assertEquals(MusicVideo3, LabelMusicPortfolio.getFirst());
        assertEquals(MusicVideo4, LabelMusicPortfolio.getLast());
        LabelMusicPortfolio.addToFront(MusicVideo1);
        assertEquals(MusicVideo1, LabelMusicPortfolio.getFirst());
        assertEquals(MusicVideo4, LabelMusicPortfolio.getLast());
        LabelMusicPortfolio.remove(MusicVideo4, comparator);
        assertEquals(2, LabelMusicPortfolio.getSize());
        assertEquals(MusicVideo1, LabelMusicPortfolio.getFirst());
        assertEquals(MusicVideo3, LabelMusicPortfolio.getLast());

    }

    @Test
    public void testRetrieveFirstElement() {
        assertEquals(3, LabelMusicPortfolio.getSize());
        assertEquals(MusicVideo2, LabelMusicPortfolio.getFirst());
        assertEquals(MusicVideo4, LabelMusicPortfolio.getLast());
        LabelMusicPortfolio.addToFront(MusicVideo1);
        assertEquals(MusicVideo1, LabelMusicPortfolio.getFirst());
        assertEquals(MusicVideo1, LabelMusicPortfolio.retrieveFirstElement());
        assertEquals(MusicVideo2, LabelMusicPortfolio.getFirst());
        assertEquals(3, LabelMusicPortfolio.getSize());
    }

    @Test
    public void testRetrieveLastElement() {
        assertEquals(3, LabelMusicPortfolio.getSize());
        assertEquals(MusicVideo2, LabelMusicPortfolio.getFirst());
        assertEquals(MusicVideo4, LabelMusicPortfolio.getLast());
        LabelMusicPortfolio.addToEnd(MusicVideo5);
        assertEquals(MusicVideo5, LabelMusicPortfolio.getLast());
        assertEquals(MusicVideo5, LabelMusicPortfolio.retrieveLastElement());
        assertEquals(MusicVideo4, LabelMusicPortfolio.getLast());
        assertEquals(3, LabelMusicPortfolio.getSize());
    }

    private class MusicVideoComparator implements Comparator<MusicVideo> {

        @Override
        public int compare(MusicVideo first, MusicVideo second) {
            return first.toString().compareTo(second.toString());
        }
    }

    private class MusicVideo {
        String artistName;
        String title;
        int year;

        public MusicVideo(String artistName, String title, int year) {
            this.artistName = artistName;
            this.title = title;
            this.year = year;
        }

        public String getArtistName() {
            return artistName;
        }

        public String getTitle() {
            return title;
        }

        public int getYear() {
            return year;
        }

        public String toString() {
            return (getArtistName() + " " + getTitle() + " " + getYear());
        }

    }

}