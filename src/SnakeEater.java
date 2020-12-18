public class SnakeEater extends Animal {
    public int age;
    public int cubsPerYear;
    public int lifeSpan;

    public SnakeEater() {
        super.lifeSpan = 174;
        super.age = 0;
        super.cubsPerYear = 5;
    }

    @Override
    public void eat(Animal victim) {
        super.eat(victim);
    }

    @Override
    public Animal giveBirth() {
        return new SnakeEater();
    }

    @Override
    public void die() {
        super.die();
    }
}
