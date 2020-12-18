public class Snake extends Animal {
    public int age;
    public int cubsPerYear;
    public int lifeSpan;

    public Snake() {
        super.lifeSpan = 90;
        super.age = 0;
        super.cubsPerYear = 16;
    }

    @Override
    public void eat(Animal victim) {
        super.eat(victim);
    }

    @Override
    public Animal giveBirth() {
        return new Snake();
    }

    @Override
    public void die() {
        super.die();
    }
}
