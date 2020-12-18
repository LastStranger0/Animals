public class Animal {
    public int age;
    public int cubsPerYear;
    public int lifeSpan;

    public void eat(Animal victim) {
        victim.die();
    }

    public Animal giveBirth() {
        return new Animal();
    }

    public void die() {

    }
}
