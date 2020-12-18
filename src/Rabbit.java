public class Rabbit extends Animal {
    public int age;
    public int cubsPerYear;
    public int lifeSpan;

    public Rabbit() {
        super.lifeSpan = 18;
        super.age = 0;
        super.cubsPerYear = 30;
    }

    @Override
    public Animal giveBirth() {
        return new Rabbit();
    }

    @Override
    public void die() {
        super.die();
    }
}
