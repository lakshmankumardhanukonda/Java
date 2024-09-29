package collections;

import java.util.*;
import java.util.concurrent.*;

enum Days {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class CollectionsDemo {

    ArrayList<String> arrayList=new ArrayList<>();

    LinkedList<String> linkedList=new LinkedList<>();

    List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

    HashSet<String> hashSet=new HashSet<>();

    LinkedHashSet<String> linkedHashSet=new LinkedHashSet<>();

    TreeSet<String> treeSet=new TreeSet<>();

    Set<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();

    Set<Days> enumSet = EnumSet.of(Days.MONDAY,Days.TUESDAY, Days.WEDNESDAY, Days.THURSDAY, Days.FRIDAY, Days.SATURDAY, Days.SUNDAY);

    ConcurrentSkipListSet<String> concurrentSkipListSet = new ConcurrentSkipListSet<>();

    HashMap<Integer,String> hashMap=new HashMap<Integer,String>();

    LinkedHashMap<Integer,String> linkedHashMap=new LinkedHashMap<Integer,String>();

    TreeMap<Integer,String> treeMap=new TreeMap<Integer,String>();

    EnumMap<Days, String> enumMap = new EnumMap<>(Days.class);

    WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();

    IdentityHashMap<String, String> identityHashMap = new IdentityHashMap<>();

    ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();

    ConcurrentSkipListMap<String, String> concurrentSkipListMap = new ConcurrentSkipListMap<>();

    PriorityQueue<String> priorityQueue=new PriorityQueue<String>();

    Deque<String> arrayDeque = new ArrayDeque<String>();

    ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

    ConcurrentLinkedDeque<String> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();

    ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);

    PriorityBlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<>();

    SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();

    DelayQueue<DelayedElement> delayQueue = new DelayQueue<DelayedElement>();

    LinkedBlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<>();

    Hashtable<Integer,String> hashtable=new Hashtable<Integer,String>();

    Properties properties=new Properties();

    Vector<String> vector = new Vector<String>();

    Stack<String> stack = new Stack<>();
}

class DelayedElement implements Delayed {
    private long delayTime;
    private long expireTime;

    public DelayedElement(long delayTime) {
        this.delayTime = delayTime;
        this.expireTime = System.currentTimeMillis() + delayTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(expireTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.expireTime, ((DelayedElement) o).expireTime);
    }
}
