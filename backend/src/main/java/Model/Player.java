package Model;

import jakarta.persistence.*;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@Entity
@Table(name= "player")
public class Player {
    public Player() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private String position;
    @Column()
    private Integer height;
    @Column()
    private Integer weight;

    public Player(Integer id, String name, Integer age, String position, Integer height, Integer weight) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.height = height;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return getId().equals(player.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
