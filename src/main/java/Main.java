import Engine.*;
import Engine.Object;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.glfw.GLFW.*;


public class Main {

    private Window window = new Window(800, 800, "Hello World");
    boolean check = true;
    private ArrayList<Object> objects = new ArrayList<>();
    private ArrayList<Object> objectsRectangle = new ArrayList<>();
    private List<Vector3f> circle = new ArrayList<>();
    private ArrayList<Rectangle> stars = new ArrayList<>();
    MouseInput mouseInput;

    private ArrayList<Object> objectsPointsControl = new ArrayList<>();
    private Object controlLine;
    private ArrayList<Object> curves = new ArrayList<>();
    private ArrayList<Vector3f> center = new ArrayList<>();
    private ArrayList<Sphere> planets = new ArrayList<>();
    Sphere kotak;

    private ArrayList<Sphere> kepala = new ArrayList<>();
    private ArrayList<Sphere> kepala1 = new ArrayList<>();
    private ArrayList<Sphere> kepala2 = new ArrayList<>();
    private ArrayList<Sphere> ndas = new ArrayList<>();
    private ArrayList<Sphere> ruangan = new ArrayList<>();
    private ArrayList<Sphere> standing = new ArrayList<>();
    private ArrayList<Object> lightbulb = new ArrayList<>();
    boolean isRoofExist = false;
    int roofCount = 0;
    int change = 1;

    int countDegree = 0;
    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(), window.getHeight());


    public void init() {
        window.init();
        GL.createCapabilities();

        ruangan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).translateObject(-2.f, 0.f, 0.15f);
        ruangan.get(0).scaleObject(1f, 5f, 35f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(0).translateObject(2.0f, 0.f, 0f);
        ruangan.get(0).getChildObject().get(0).scaleObject(0.5f, 5f, 13f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(1).translateObject(0.315f, 0.f, 3.5f);
        ruangan.get(0).getChildObject().get(1).scaleObject(13f, 5f, 1f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(2).translateObject(14.5f, 0.f, 0.5f);
        ruangan.get(0).getChildObject().get(2).scaleObject(0.5f, 5f, 13f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(3).translateObject(9.5f, 0.f, 1.2f);
        ruangan.get(0).getChildObject().get(3).scaleObject(0.5f, 5f, 7f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(4).translateObject(0.11f, 0.f, 6.8f);
        ruangan.get(0).getChildObject().get(4).scaleObject(13f, 5f, 1f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(5).translateObject(0.35f, 0.f, 10.f);
        ruangan.get(0).getChildObject().get(5).scaleObject(13f, 5f, 1f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(6).translateObject(0.05f, 0.f, -6.6f);
        ruangan.get(0).getChildObject().get(6).scaleObject(25f, 5f, 1f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(7).translateObject(0.3f, 0.f, -3.3f);
        ruangan.get(0).getChildObject().get(7).scaleObject(10f, 5f, 1f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(8).translateObject(5f, 0.f, 0f);
        ruangan.get(0).getChildObject().get(8).scaleObject(1f, 5f, 13f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(9).translateObject(7.3f, 0.f, -0.07f);
        ruangan.get(0).getChildObject().get(9).scaleObject(1f, 5f, 20f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(10).translateObject(-5.f, 0.f, 0.07f);
        ruangan.get(0).getChildObject().get(10).scaleObject(1f, 5f, 35f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(11).translateObject(-0.18f, 0.f, 17f);
        ruangan.get(0).getChildObject().get(11).scaleObject(20f, 5f, 1f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(12).translateObject(1f, 0.f, 0.9f);
        ruangan.get(0).getChildObject().get(12).scaleObject(1f, 5f, 15f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(13).translateObject(-8.5f, 0.f, 0.6f);
        ruangan.get(0).getChildObject().get(13).scaleObject(1f, 5f, 20f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(14).translateObject(-1f, 0.f, 7f);
        ruangan.get(0).getChildObject().get(14).scaleObject(11f, 5f, 1f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(15).translateObject(-0.5f, 0.f, 11f);
        ruangan.get(0).getChildObject().get(15).scaleObject(20f, 5f, -0.5f);


        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(16).translateObject(-13.5f, 0.f, 0.6f);
        ruangan.get(0).getChildObject().get(16).scaleObject(1f, 5f, 20f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(17).translateObject(-12.5f, 0.f, -0.2f);
        ruangan.get(0).getChildObject().get(17).scaleObject(0.9f, 5f, 20f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(18).translateObject(-1.575f, 0.f, 1f);
        ruangan.get(0).getChildObject().get(18).scaleObject(11f, 5f, 1f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(19).translateObject(-19.75f, 0.f, 0.31f);
        ruangan.get(0).getChildObject().get(19).scaleObject(1f, 5f, 20f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(20).translateObject(-19.75f, 0.f, -0.2f);
        ruangan.get(0).getChildObject().get(20).scaleObject(1f, 5f, 20f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(21).translateObject(-0.75f, 0.f, 17.75f);
        ruangan.get(0).getChildObject().get(21).scaleObject(20f, 5f, -0.5f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(22).translateObject(-1.575f, 0.f, 1f);
        ruangan.get(0).getChildObject().get(22).scaleObject(11f, 5f, 1f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(23).translateObject(-19.75f, 0.f, 0.8f);
        ruangan.get(0).getChildObject().get(23).scaleObject(1f, 5f, 20f);

        //Tembok Putih
        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(24).translateObject(19f, 0.f, 0.8f);
        ruangan.get(0).getChildObject().get(24).scaleObject(1f, 5f, 20f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(25).translateObject(1f, 0.f, 11f);
        ruangan.get(0).getChildObject().get(25).scaleObject(15f, 5f, 1f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(26).translateObject(1f, 0.f, 20.75f);
        ruangan.get(0).getChildObject().get(26).scaleObject(15f, 5f, 1f);

        ruangan.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        ruangan.get(0).getChildObject().get(27).translateObject(11.5f, 0.f, 0.8f);
        ruangan.get(0).getChildObject().get(27).scaleObject(1f, 5f, 20f);

        //lantai
        standing.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 0.7f, 0.3f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 1
        ));
        standing.get(0).translateObject(0f, -1.5f, 0.1f);
        standing.get(0).scaleObject(80f, 1f, 60f);

        lightbulb.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                Arrays.asList(0f, 0f, 0f),
                0.14f,
                0.14f,
                0.14f, 36,
                18, 2
        ));
        lightbulb.get(0).translateObject(6.23f, 1.3f, 6.69f);

        lightbulb.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                Arrays.asList(0f, 0f, 0f),
                0.14f,
                0.14f,
                0.14f, 36,
                18, 2
        ));
        lightbulb.get(0).getChildObject().get(0).translateObject(-5.07f, 1.3f, 13.73f);

        lightbulb.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                Arrays.asList(0f, 0f, 0f),
                0.14f,
                0.14f,
                0.14f, 36,
                18, 2
        ));
        lightbulb.get(0).getChildObject().get(1).translateObject(-17.07f, 1.6f, -2.504f);

        lightbulb.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                Arrays.asList(0f, 0f, 0f),
                0.14f,
                0.14f,
                0.14f, 36,
                18, 2
        ));
        lightbulb.get(0).getChildObject().get(2).translateObject(-17.07f, 1.3f, 15.085f);

        lightbulb.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                Arrays.asList(0f, 0f, 0f),
                0.14f,
                0.14f,
                0.14f, 36,
                18, 2
        ));
        lightbulb.get(0).getChildObject().get(3).translateObject(-10.9f, 1.3f, 3.9f);

        kepala.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 360,
                180, 2));
        kepala.get(0).translateObject(0f, 0f, 0f);
        //white face
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.45f,
                0.45f,
                0.45f, 360,
                180, 2));
        kepala.get(0).getChildObject().get(0).translateObject(0f, -0.05f, 0.1f);

        //outline mata
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.12f,
                0.12f,
                0.14f, 36,
                18, 2));
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.12f,
                0.12f,
                0.14f, 36,
                18, 2));
        kepala.get(0).getChildObject().get(1).translateObject(-0.12f, 0.2f, 0.36f);
        kepala.get(0).getChildObject().get(2).translateObject(0.12f, 0.21f, 0.36f);

        //mata
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.1f,
                0.1f,
                0.12f, 360,
                180, 2));
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.1f,
                0.1f,
                0.12f, 360,
                180, 2));
        kepala.get(0).getChildObject().get(3).translateObject(-0.12f, 0.2f, 0.4f);
        kepala.get(0).getChildObject().get(4).translateObject(0.12f, 0.21f, 0.4f);

        //pupil
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                Arrays.asList(0f, 0f, 0f),
                0.02f,
                0.02f,
                0.02f, 360,
                180, 2));
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                Arrays.asList(0f, 0f, 0f),
                0.02f,
                0.02f,
                0.02f, 360,
                180, 2));
        kepala.get(0).getChildObject().get(5).translateObject(-0.08f, 0.2f, 0.52f);
        kepala.get(0).getChildObject().get(6).translateObject(0.08f, 0.2f, 0.52f);

        //nose
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.07f,
                0.07f,
                0.07f, 360,
                180, 2));
        kepala.get(0).getChildObject().get(7).translateObject(0f, 0.05f, 0.55f);

        //mulut
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.15f,
                0.05f,
                0.15f, 360,
                180, 2));
        kepala.get(0).getChildObject().get(8).translateObject(0f, -0.13f, 0.43f);

        //badan
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.45f,
                0.45f,
                0.6f, 360,
                180, 3));
        kepala.get(0).getChildObject().get(9).translateObject(0f, -0.4f, 0f);

        //badan putih
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.33f,
                0.4f,
                0.4f, 360,
                180, 2));

        kepala.get(0).getChildObject().get(10).translateObject(0f, -0.5f, 0.1f);

        //outline kantong ajaib

        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.35f,
                0.35f,
                0.35f, 360,
                180, 9));
        kepala.get(0).getChildObject().get(11).translateObject(0f, 0.9f, -0.525f);
        kepala.get(0).getChildObject().get(11).rotateObject(180f, 0f, 0f, 0f);

        //kantong ajaib
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.30f,
                0.30f,
                0.30f, 360,
                180, 9));
        kepala.get(0).getChildObject().get(12).translateObject(0f, 0.9f, -0.60f);
        kepala.get(0).getChildObject().get(12).rotateObject(180f, 0f, 0f, 0f);

        //kalung
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.4f,
                0.3f,
                0.1f, 360,
                180, 3));
        kepala.get(0).getChildObject().get(13).translateObject(0f, -0.29f, 0.24f);

        //lonceng
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 0.65f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.05f,
                0.05f,
                0.05f, 360,
                180, 2));
        kepala.get(0).getChildObject().get(14).translateObject(0f, -0.33f, 0.55f);


        //lengan
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.1f,
                0.15f,
                0.25f, 360,
                180, 3));

        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.1f,
                0.15f,
                0.25f, 360,
                180, 3));
        kepala.get(0).getChildObject().get(15).translateObject(-0.48f, -.5f, 0f);
        kepala.get(0).getChildObject().get(16).translateObject(0.48f, -.5f, 0f);

        //telapak tangan
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.11f,
                0.11f,
                0.11f, 360,
                180, 2));
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.11f,
                0.11f,
                0.11f, 360,
                180, 2));
        kepala.get(0).getChildObject().get(17).translateObject(-0.49f, -.73f, 0f);
        kepala.get(0).getChildObject().get(18).translateObject(0.49f, -.73f, 0f);

        //paha
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.2f,
                0.2f,
                0.25f, 360,
                180, 3));


        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.2f,
                0.2f,
                0.25f, 360,
                180, 3));
        kepala.get(0).getChildObject().get(19).translateObject(-0.2f, -0.9f, 0f);
        kepala.get(0).getChildObject().get(20).translateObject(0.2f, -0.9f, 0f);

        //telapak kaki
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.2f,
                0.2f,
                0.1f, 360,
                180, 3));
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.2f,
                0.2f,
                0.1f, 360,
                180, 3));
        kepala.get(0).getChildObject().get(21).translateObject(-0.21f, -1.2f, 0f);
        kepala.get(0).getChildObject().get(22).translateObject(0.21f, -1.2f, 0f);


        //kumis
        kepala.get(0).getChildObject().add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f)
                , Arrays.asList(0f, 0f, 0f)));
        kepala.get(0).getChildObject().get(23).addVertices(new Vector3f(-0.4f, -0.075f, 0.55f));
        kepala.get(0).getChildObject().get(23).addVertices(new Vector3f(-0.3f, 0.1f, 0.55f));
        kepala.get(0).getChildObject().get(23).addVertices(new Vector3f(-0.07f, -0.0225f, 0.55f));
        kepala.get(0).getChildObject().get(23).translateObject(0f, 0f, 0.5f);

        kepala.get(0).getChildObject().add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f)
                , Arrays.asList(0f, 0f, 0f)));
        kepala.get(0).getChildObject().get(24).addVertices(new Vector3f(-0.4f, -0.275f, 0f));
        kepala.get(0).getChildObject().get(24).addVertices(new Vector3f(-0.3f, 0.05f, 0f));
        kepala.get(0).getChildObject().get(24).addVertices(new Vector3f(-0.07f, -0.0425f, 0f));
        kepala.get(0).getChildObject().get(24).translateObject(0f, 0f, 0.5f);

        kepala.get(0).getChildObject().add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f)
                , Arrays.asList(0f, 0f, 0f)));
        kepala.get(0).getChildObject().get(25).addVertices(new Vector3f(0.4f, -0.075f, 0f));
        kepala.get(0).getChildObject().get(25).addVertices(new Vector3f(0.3f, 0.1f, 0f));
        kepala.get(0).getChildObject().get(25).addVertices(new Vector3f(0.07f, -0.0225f, 0f));
        kepala.get(0).getChildObject().get(25).translateObject(0f, 0f, 0.5f);

        kepala.get(0).getChildObject().add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f)
                , Arrays.asList(0f, 0f, 0f)));
        kepala.get(0).getChildObject().get(26).addVertices(new Vector3f(0.4f, -0.275f, 0f));
        kepala.get(0).getChildObject().get(26).addVertices(new Vector3f(0.3f, 0.05f, 0f));
        kepala.get(0).getChildObject().get(26).addVertices(new Vector3f(0.07f, -0.0425f, 0f));
        kepala.get(0).getChildObject().get(26).translateObject(0f, 0f, 0.5f);

        //topi
        kepala.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 0.65f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.1f,
                0.15f,
                0.15f, 360,
                180, 6));
        kepala.get(0).getChildObject().get(27).rotateObject((float) Math.toRadians(60.0), 0f, 0f, -0.5f);
        kepala.get(0).getChildObject().get(27).translateObject(-0.4f, 0.35f, 0f);

        ndas.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.2f,
                0.2f,
                0.1f, 360,
                180, 3));
        ndas.get(0).translateObject(1f, 0f, 0f);

        //head
        kepala1.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.8f, 0.8f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.5f,
                0.5f,
                0.5f, 36,
                18, 3));

        kepala1.get(0).translateObject(-1.5f, -0.07f, 0f);


        //white face
        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.45f,
                0.45f,
                0.5f, 36,
                18, 2));
        kepala1.get(0).getChildObject().get(0).translateObject(-1.5f, -0.05f, 0.1f);
//        kepala1.get(0).getChildObject().get(0).setCenterPoint(Arrays.asList(-1.5f, 0.0f, 0.0f));

        //line mata
        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 0f),
                Arrays.asList(0f, 0f, 0f),
                0.11f,
                0.11f,
                0.13f, 36,
                18, 2));
        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.11f,
                0.11f,
                0.13f, 36,
                18, 2));
        kepala1.get(0).getChildObject().get(1).translateObject(-1.62f, 0.2f, 0.41f);
        kepala1.get(0).getChildObject().get(2).translateObject(-1.38f, 0.21f, 0.41f);
//        kepala1.get(0).getChildObject().get(1).setCenterPoint(Arrays.asList(0.25f, 0.0f, 0.0f));
//        kepala1.get(0).getChildObject().get(2).setCenterPoint(Arrays.asList(0.25f, 0.0f, 0.0f));

        //mata
        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.1f,
                0.1f,
                0.12f, 36,
                18, 2));
        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.1f,
                0.1f,
                0.12f, 36,
                18, 2));
        kepala1.get(0).getChildObject().get(3).translateObject(-1.62f, 0.2f, 0.425f);
        kepala1.get(0).getChildObject().get(4).translateObject(-1.38f, 0.21f, 0.425f);

        //pupil
        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                Arrays.asList(0f, 0f, 0f),
                0.03f,
                0.03f,
                0.03f, 36,
                18, 2));
        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                Arrays.asList(0f, 0f, 0f),
                0.03f,
                0.03f,
                0.03f, 36,
                18, 2));
        kepala1.get(0).getChildObject().get(5).translateObject(-1.6f, 0.17f, 0.525f);
        kepala1.get(0).getChildObject().get(6).translateObject(-1.4f, 0.17f, 0.525f);

        //hidung
        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.8f, 0.47f, 0.54f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.1f,
                -0.05f,
                0.1f, 36,
                18, 2));
        kepala1.get(0).getChildObject().get(7).translateObject(-1.5f, -0.065f, 0.6f);

        //badan
        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.8f, 0.8f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.45f,
                0.45f,
                0.6f, 36,
                18, 3));
        kepala1.get(0).getChildObject().get(8).translateObject(-1.5f, -0.4f, 0f);

        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.33f,
                0.4f,
                0.4f, 108,
                72, 2));
        kepala1.get(0).getChildObject().get(9).translateObject(-1.5f, -0.5f, 0.125f);

        //kalung
        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.3f, 0.93f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.275f,
                0.275f,
                0.45f, 36,
                18, 3));
        kepala1.get(0).getChildObject().get(10).translateObject(-1.5f, -0.25f, 0.25f);

        //lonceng
        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 0.65f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.05f,
                0.05f,
                0.05f, 36,
                18, 3));
        kepala1.get(0).getChildObject().get(11).translateObject(-1.5f, -0.48f, 0.5f);


        //lengan
        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.8f, 0.8f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.25f,
                0.1f,
                0.15f, 36,
                18, 3));

        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.8f, 0.8f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.1f,
                0.25f,
                0.25f, 36,
                18, 3));
        kepala1.get(0).getChildObject().get(12).translateObject(-2.135f, -.375f, 0f);
        kepala1.get(0).getChildObject().get(13).translateObject(-0.98f, -.5f, 0f);

        //telapak tangan
        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.11f,
                0.11f,
                0.11f, 36,
                18, 3));
        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.11f,
                0.11f,
                0.11f, 36,
                18, 3));
        kepala1.get(0).getChildObject().get(14).translateObject(-2.225f, -.375f, 0.1f);
        kepala1.get(0).getChildObject().get(15).translateObject(-0.99f, -.7f, 0.1f);

        //paha
        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.8f, 0.8f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.2f,
                0.25f,
                0.25f, 36,
                18, 3));


        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.8f, 0.8f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.2f,
                0.25f,
                0.25f, 36,
                18, 3));
        kepala1.get(0).getChildObject().get(16).translateObject(-1.7f, -0.9f, 0f);
        kepala1.get(0).getChildObject().get(17).translateObject(-1.3f, -0.9f, 0f);

        //telapak kaki
        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.2f,
                0.1f,
                0.1f, 36,
                18, 3));
        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.2f,
                0.1f,
                0.1f, 36,
                18, 3));
        kepala1.get(0).getChildObject().get(18).translateObject(-1.75f, -1.1f, 0.1f);
        kepala1.get(0).getChildObject().get(19).translateObject(-1.25f, -1.1f, 0.1f);

        kepala1.get(0).getChildObject().add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f),
                Arrays.asList(0f,0f,0f,0.0f)));
        kepala1.get(0).getChildObject().get(20).addVertices(new Vector3f(-0.1f, -0.02f, 0.2f));
        kepala1.get(0).getChildObject().get(20).addVertices(new Vector3f(-0.025f, 0.025f, 0.2f));
        kepala1.get(0).getChildObject().get(20).addVertices(new Vector3f(0.1f, -0.01f, 0.2f));
        kepala1.get(0).getChildObject().get(20).translateObject(-1.5f, 0f, 0.6f);

        kepala1.get(0).getChildObject().add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f),
                Arrays.asList(0f,0f,0f,0.0f)));
        kepala1.get(0).getChildObject().get(21).addVertices(new Vector3f(-0.15f, -0.25f, 0.2f));
        kepala1.get(0).getChildObject().get(21).addVertices(new Vector3f(-0.025f, -0.4f, 0.2f));
        kepala1.get(0).getChildObject().get(21).addVertices(new Vector3f(0.15f, -0.25f, 0.2f));
        kepala1.get(0).getChildObject().get(21).translateObject(-1.5f, 0f, 0.525f);

        //baling bambu
        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.3f,
                0.05f,
                0.2f, 36,
                18, 2));
        kepala1.get(0).getChildObject().get(22).translateObject(-1.5f, 0.8f, 0.1f);

        kepala1.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.05f,
                0.375f,
                0.2f, 36,
                18, 1));
        kepala1.get(0).getChildObject().get(23).translateObject(-1.5f, 0.6f, 0.1f);

        //head
        kepala2.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(.58f, .58f, .58f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.3f,
                0.3f,
                0.3f, 36,
                18, 2));
        kepala2.get(0).translateObject(1.5f, 0f, 0.1f);

        //mata
        kepala2.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.07f,
                0.1f,
                0.11f, 36,
                18, 2));
        kepala2.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.07f,
                0.1f,
                0.11f, 36,
                18, 2));
        kepala2.get(0).getChildObject().get(0).translateObject(1.41f, 0.07f, 0.3f);
        kepala2.get(0).getChildObject().get(1).translateObject(1.59f, 0.07f, 0.3f);

        //pupil
        kepala2.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                Arrays.asList(0f, 0f, 0f),
                0.025f,
                0.028f,
                0.025f, 36,
                18, 2));
        kepala2.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                Arrays.asList(0f, 0f, 0f),
                0.025f,
                0.028f,
                0.025f, 36,
                18, 2));
        kepala2.get(0).getChildObject().get(2).translateObject(1.42f, 0.05f, 0.39f);
        kepala2.get(0).getChildObject().get(3).translateObject(1.58f, 0.05f, 0.39f);

        //nose
        kepala2.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.07f,
                0.05f,
                0.05f, 36,
                18, 2));
        kepala2.get(0).getChildObject().get(4).translateObject(1.5f, -0.09f, 0.39f);

        //telinga
        kepala2.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(.58f, 0.58f, 0.58f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.17f,
                0.17f,
                0.17f, 36,
                18, 2));
        kepala2.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(.58f, 0.58f, 0.58f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.17f,
                0.17f,
                0.17f, 36,
                18, 2));
        kepala2.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.8f, 0.47f, 0.54f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.13f,
                0.13f,
                0.13f, 36,
                18, 2));
        kepala2.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.8f, 0.47f, 0.54f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.13f,
                0.13f,
                0.13f, 36,
                18, 2));
        kepala2.get(0).getChildObject().get(5).translateObject(1.32f, 0.33f, 0.05f);
        kepala2.get(0).getChildObject().get(6).translateObject(1.68f, 0.33f, 0.05f);
        kepala2.get(0).getChildObject().get(7).translateObject(1.32f, 0.33f, 0.1f);
        kepala2.get(0).getChildObject().get(8).translateObject(1.68f, 0.33f, 0.1f);



        //badan
        kepala2.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.58f, 0.58f, 0.58f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.25f,
                0.25f,
                0.35f, 36,
                18, 3));
        kepala2.get(0).getChildObject().get(9).translateObject(1.5f, -0.3f, 0.1f);

        //lengan
        kepala2.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.58f, 0.58f, 0.58f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.06f,
                0.1f,
                0.16f, 36,
                18, 3));

        kepala2.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.58f, 0.58f, 0.58f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.06f,
                0.1f,
                0.16f, 36,
                18, 3));
        kepala2.get(0).getChildObject().get(10).translateObject(1.25f, -.4f, 0.1f);
        kepala2.get(0).getChildObject().get(11).translateObject(1.75f, -.4f, 0.1f);

        //telapak tangan
        kepala2.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.8f, 0.47f, 0.54f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.05f,
                0.05f,
                0.05f, 36,
                18, 2));
        kepala2.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.8f, 0.47f, 0.54f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.05f,
                0.05f,
                0.05f, 36,
                18, 2));
        kepala2.get(0).getChildObject().get(12).translateObject(1.25f, -.55f, 0.15f);
        kepala2.get(0).getChildObject().get(13).translateObject(1.75f, -.55f, 0.15f);

        //paha
        kepala2.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.58f, 0.58f, 0.58f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.06f,
                0.1f,
                0.16f, 36,
                18, 3));


        kepala2.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.58f, 0.58f, .58f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.06f,
                0.1f,
                0.16f, 36,
                18, 3));
        kepala2.get(0).getChildObject().get(14).translateObject(1.36f, -0.69f, 0.1f);
        kepala2.get(0).getChildObject().get(15).translateObject(1.64f, -0.69f, 0.1f);

        //telapak kaki
        kepala2.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.8f, 0.47f, 0.54f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.05f,
                0.05f,
                0.05f, 36,
                18, 3));
        kepala2.get(0).getChildObject().add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                        )
                ),
                new Vector4f(0.8f, 0.47f, 0.54f, 0.0f),
                Arrays.asList(0f, 0f, 0f),
                0.05f,
                0.05f,
                0.05f, 36,
                18, 3));
        kepala2.get(0).getChildObject().get(16).translateObject(1.36f, -.85f, 0.11f);
        kepala2.get(0).getChildObject().get(17).translateObject(1.64f, -.85f, 0.11f);


        //kumis
        kepala2.get(0).getChildObject().add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f)
                ,Arrays.asList(0f,0f,0f)));
        kepala2.get(0).getChildObject().get(18).addVertices(new Vector3f(-0.4f, -0.075f, 0.1f));
        kepala2.get(0).getChildObject().get(18).addVertices(new Vector3f(-0.3f, 0.1f, 0.1f));
        kepala2.get(0).getChildObject().get(18).addVertices(new Vector3f(-0.07f, -0.0225f, 0.1f));
        kepala2.get(0).getChildObject().get(18).translateObject(1.5f,0f,0.38f);

        kepala2.get(0).getChildObject().add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f)
                ,Arrays.asList(0f,0f,0f)));
        kepala2.get(0).getChildObject().get(19).addVertices(new Vector3f(-0.4f, -0.275f, 0.1f));
        kepala2.get(0).getChildObject().get(19).addVertices(new Vector3f(-0.3f, 0.05f, 0.1f));
        kepala2.get(0).getChildObject().get(19).addVertices(new Vector3f(-0.07f, -0.0425f, 0.1f));
        kepala2.get(0).getChildObject().get(19).translateObject(1.5f,0f,0.38f);

        kepala2.get(0).getChildObject().add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f)
                ,Arrays.asList(0f,0f,0f)));
        kepala2.get(0).getChildObject().get(20).addVertices(new Vector3f(0.4f, -0.075f, 0.1f));
        kepala2.get(0).getChildObject().get(20).addVertices(new Vector3f(0.3f, 0.1f, 0.1f));
        kepala2.get(0).getChildObject().get(20).addVertices(new Vector3f(0.07f, -0.0225f, 0.1f));
        kepala2.get(0).getChildObject().get(20).translateObject(1.5f,0f,0.38f);

        kepala2.get(0).getChildObject().add(new Curve(Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f)
                ,Arrays.asList(0f,0f,0f)));
        kepala2.get(0).getChildObject().get(21).addVertices(new Vector3f(0.4f, -0.275f, 0.1f));
        kepala2.get(0).getChildObject().get(21).addVertices(new Vector3f(0.3f, 0.05f, 0.1f));
        kepala2.get(0).getChildObject().get(21).addVertices(new Vector3f(0.07f, -0.0425f, 0.1f));
        kepala2.get(0).getChildObject().get(21).translateObject(1.5f,0f,0.38f);

        for (Sphere kepala : kepala
        ) {
            for (Sphere ndas : ndas
            ) {
                kepala.translateObject(6f, 0f, 8.5f);
                ndas.translateObject(6f, 0f, 8.5f);
                camera.setPosition(kepala.getCenterPoint().get(0), kepala.getCenterPoint().get(1) + 5f, kepala.getCenterPoint().get(2));
                camera.setRotation(1.5f, 0f, 0f);
            }
        }

        for (Sphere kepala1 : kepala1
        ) {
                kepala1.translateObject(15.08f, 0f, 14.08f);
        }

        for (Sphere kepala2 : kepala2
        ) {
            kepala2.translateObject(16.08f, -0.28f, 15.08f);
        }
    }

    List<Vector3f> collisionPoint = Arrays.asList(
            new Vector3f(6.39f, 0.0f, 9.0f),
            new Vector3f(6.29f, 0.0f, 9.0f),
            new Vector3f(5.4f, 0.0f, 9.0f),
            new Vector3f(5.6f, 0.0f, 9.0f),
            new Vector3f(5.7f, 0.0f, 9.0f),
            new Vector3f(5.5f, 0.0f, 9.0f),
            new Vector3f(5.8f, 0.0f, 9.0f),
            new Vector3f(5.9f, 0.0f, 9.0f),
            new Vector3f(6.0f, 0.0f, 9.0f),
            new Vector3f(6.1f, 0.0f, 9.0f),
            new Vector3f(6.49f, 0.0f, 9.0f),
            new Vector3f(6.49f, 0.0f, 8.4f),
            new Vector3f(6.49f, 0.0f, 8.5f),
            new Vector3f(6.49f, 0.0f, 8.3f),
            new Vector3f(6.49f, 0.0f, 8.6f),
            new Vector3f(6.49f, 0.0f, 8.7f),
            new Vector3f(6.49f, 0.0f, 8.8f),
            new Vector3f(6.49f, 0.0f, 8.9f),
            new Vector3f(6.49f, 0.0f, 8.2f),
            new Vector3f(6.49f, 0.0f, 8.1f),
            new Vector3f(6.49f, 0.0f, 8.0f),
            new Vector3f(6.49f, 0.0f, 7.9f),
            new Vector3f(6.49f, 0.0f, 7.8f),
            new Vector3f(6.49f, 0.0f, 7.7f),
            new Vector3f(6.49f, 0.0f, 7.6f),
            new Vector3f(6.49f, 0.0f, 7.5f),
            new Vector3f(6.49f, 0.0f, 7.4f),
            new Vector3f(6.49f, 0.0f, 7.3f),
            new Vector3f(6.49f, 0.0f, 7.2f),
            new Vector3f(6.49f, 0.0f, 7.1f),
            new Vector3f(6.49f, 0.0f, 7.0f),
            new Vector3f(6.49f, 0.0f, 6.9f),
            new Vector3f(6.49f, 0.0f, 6.7f),
            new Vector3f(6.49f, 0.0f, 6.8f),
            new Vector3f(6.49f, 0.0f, 6.5f),
            new Vector3f(6.49f, 0.0f, 6.4f),
            new Vector3f(6.49f, 0.0f, 6.3f),
            new Vector3f(6.49f, 0.0f, 6.2f),
            new Vector3f(6.49f, 0.0f, 6.1f),
            new Vector3f(6.49f, 0.0f, 6.0f),
            new Vector3f(6.49f, 0.0f, 5.9f),
            new Vector3f(6.49f, 0.0f, 5.8f),
            new Vector3f(6.49f, 0.0f, 5.7f),
            new Vector3f(6.49f, 0.0f, 5.6f),
            new Vector3f(6.49f, 0.0f, 5.5f),
            new Vector3f(6.49f, 0.0f, 5.4f),
            new Vector3f(6.49f, 0.0f, 5.3f),
            new Vector3f(6.49f, 0.0f, 5.2f),
            new Vector3f(6.49f, 0.0f, 5.1f),
            new Vector3f(6.49f, 0.0f, 5.0f),
            new Vector3f(6.49f, 0.0f, 4.9f),
            new Vector3f(6.49f, 0.0f, 4.8f),
            new Vector3f(6.49f, 0.0f, 4.7f),
            new Vector3f(6.49f, 0.0f, 4.6f),
            new Vector3f(6.49f, 0.0f, 4.5f),
            new Vector3f(6.49f, 0.0f, 4.4f),
            new Vector3f(6.49f, 0.0f, 4.3f),
            new Vector3f(5.5f, 0.0f, 8.9f),
            new Vector3f(5.5f, 0.0f, 8.7f),
            new Vector3f(5.5f, 0.0f, 8.6f),
            new Vector3f(5.5f, 0.0f, 8.5f),
            new Vector3f(5.5f, 0.0f, 8.4f),
            new Vector3f(5.5f, 0.0f, 8.3f),
            new Vector3f(5.5f, 0.0f, 8.2f),
            new Vector3f(5.5f, 0.0f, 8.1f),
            new Vector3f(5.5f, 0.0f, 8.0f),
            new Vector3f(5.5f, 0.0f, 7.9f),
            new Vector3f(5.5f, 0.0f, 7.8f),
            new Vector3f(5.5f, 0.0f, 7.7f),
            new Vector3f(5.5f, 0.0f, 7.6f),
            new Vector3f(5.5f, 0.0f, 7.5f),
            new Vector3f(5.5f, 0.0f, 7.4f),
            new Vector3f(5.5f, 0.0f, 7.3f),
            new Vector3f(5.5f, 0.0f, 7.2f),
            new Vector3f(5.5f, 0.0f, 7.1f),
            new Vector3f(5.5f, 0.0f, 7.0f),
            new Vector3f(5.5f, 0.0f, 6.9f),
            new Vector3f(5.5f, 0.0f, 6.8f),
            new Vector3f(6.4f, 0.0f, 4.2f),
            new Vector3f(6.3f, 0.0f, 4.2f),
            new Vector3f(6.2f, 0.0f, 4.2f),
            new Vector3f(6.1f, 0.0f, 4.2f),
            new Vector3f(6.0f, 0.0f, 4.2f),
            new Vector3f(5.9f, 0.0f, 4.2f),
            new Vector3f(5.8f, 0.0f, 4.2f),
            new Vector3f(5.7f, 0.0f, 4.2f),
            new Vector3f(5.6f, 0.0f, 4.2f),
            new Vector3f(5.5f, 0.0f, 4.2f),
            new Vector3f(5.4f, 0.0f, 4.2f),
            new Vector3f(5.3f, 0.0f, 4.2f),
            new Vector3f(5.2f, 0.0f, 4.2f),
            new Vector3f(5.1f, 0.0f, 4.2f),
            new Vector3f(5.0f, 0.0f, 4.2f),
            new Vector3f(4.9f, 0.0f, 4.2f),
            new Vector3f(4.8f, 0.0f, 4.2f),
            new Vector3f(4.7f, 0.0f, 4.2f),
            new Vector3f(4.6f, 0.0f, 4.2f),
            new Vector3f(4.5f, 0.0f, 4.2f),
            new Vector3f(4.4f, 0.0f, 4.2f),
            new Vector3f(4.3f, 0.0f, 4.2f),
            new Vector3f(4.2f, 0.0f, 4.2f),
            new Vector3f(4.1f, 0.0f, 4.2f),
            new Vector3f(4.0f, 0.0f, 4.2f),
            new Vector3f(3.9f, 0.0f, 4.2f),
            new Vector3f(3.8f, 0.0f, 4.2f),
            new Vector3f(3.7f, 0.0f, 4.2f),
            new Vector3f(3.6f, 0.0f, 4.2f),
            new Vector3f(3.5f, 0.0f, 4.2f),
            new Vector3f(3.4f, 0.0f, 4.2f),
            new Vector3f(3.3f, 0.0f, 4.2f),
            new Vector3f(3.2f, 0.0f, 4.2f),
            new Vector3f(3.1f, 0.0f, 4.2f),
            new Vector3f(3.0f, 0.0f, 4.2f),
            new Vector3f(2.9f, 0.0f, 4.2f),
            new Vector3f(2.7f, 0.0f, 4.2f),
            new Vector3f(2.6f, 0.0f, 4.2f),
            new Vector3f(2.5f, 0.0f, 4.2f),
            new Vector3f(2.4f, 0.0f, 4.2f),
            new Vector3f(2.3f, 0.0f, 4.2f),
            new Vector3f(2.2f, 0.0f, 4.2f),
            new Vector3f(2.1f, 0.0f, 4.2f),
            new Vector3f(2.0f, 0.0f, 4.2f),
            new Vector3f(1.9f, 0.0f, 4.2f),
            new Vector3f(1.8f, 0.0f, 4.2f),
            new Vector3f(1.7f, 0.0f, 4.2f),
            new Vector3f(1.6f, 0.0f, 4.2f),
            new Vector3f(1.5f, 0.0f, 4.2f),
            new Vector3f(1.4f, 0.0f, 4.2f),
            new Vector3f(1.3f, 0.0f, 4.2f),
            new Vector3f(1.2f, 0.0f, 4.2f),
            new Vector3f(1.1f, 0.0f, 4.2f),
            new Vector3f(1.0f, 0.0f, 4.2f),
            new Vector3f(0.9f, 0.0f, 4.2f),
            new Vector3f(0.8f, 0.0f, 4.2f),
            new Vector3f(4.5f, 0.0f, 5.9f),
            new Vector3f(4.3f, 0.0f, 5.9f),
            new Vector3f(4.2f, 0.0f, 5.9f),
            new Vector3f(4.2f, 0.0f, 5.9f),
            new Vector3f(4.1f, 0.0f, 5.9f),
            new Vector3f(4.0f, 0.0f, 5.9f),
            new Vector3f(3.9f, 0.0f, 5.9f),
            new Vector3f(3.8f, 0.0f, 5.9f),
            new Vector3f(3.7f, 0.0f, 5.9f),
            new Vector3f(3.6f, 0.0f, 5.9f),
            new Vector3f(3.5f, 0.0f, 5.9f),
            new Vector3f(3.4f, 0.0f, 5.9f),
            new Vector3f(3.3f, 0.0f, 5.9f),
            new Vector3f(3.2f, 0.0f, 5.9f),
            new Vector3f(3.1f, 0.0f, 5.9f),
            new Vector3f(3.0f, 0.0f, 5.9f),
            new Vector3f(2.9f, 0.0f, 5.9f),
            new Vector3f(2.7f, 0.0f, 5.9f),
            new Vector3f(2.6f, 0.0f, 5.9f),
            new Vector3f(2.5f, 0.0f, 5.9f),
            new Vector3f(2.4f, 0.0f, 5.9f),
            new Vector3f(2.3f, 0.0f, 5.9f),
            new Vector3f(2.2f, 0.0f, 5.9f),
            new Vector3f(2.1f, 0.0f, 5.9f),
            new Vector3f(2.0f, 0.0f, 5.9f),
            new Vector3f(1.9f, 0.0f, 5.9f),
            new Vector3f(1.8f, 0.0f, 5.9f),
            new Vector3f(1.7f, 0.0f, 5.9f),
            new Vector3f(1.6f, 0.0f, 5.9f),
            new Vector3f(1.5f, 0.0f, 5.9f),
            new Vector3f(1.4f, 0.0f, 5.9f),
            new Vector3f(1.3f, 0.0f, 5.9f),
            new Vector3f(1.2f, 0.0f, 5.9f),
            new Vector3f(1.1f, 0.0f, 5.9f),
            new Vector3f(1.0f, 0.0f, 5.9f),
            new Vector3f(0.9f, 0.0f, 5.9f),
            new Vector3f(0.8f, 0.0f, 5.9f),
            new Vector3f(0.7f, 0.0f, 5.9f),
            new Vector3f(0.6f, 0.0f, 5.9f),
            new Vector3f(0.5f, 0.0f, 5.9f),
            new Vector3f(0.4f, 0.0f, 5.9f),
            new Vector3f(0.3f, 0.0f, 5.9f),
            new Vector3f(0.2f, 0.0f, 5.9f),
            new Vector3f(0.1f, 0.0f, 5.9f),
            new Vector3f(0.0f, 0.0f, 5.9f),
            new Vector3f(-0.1f, 0.0f, 5.9f),
            new Vector3f(-0.2f, 0.0f, 5.9f),
            new Vector3f(-0.3f, 0.0f, 5.9f),
            new Vector3f(-0.4f, 0.0f, 5.9f),
            new Vector3f(-0.5f, 0.0f, 5.9f),
            new Vector3f(-0.6f, 0.0f, 5.9f),
            new Vector3f(-0.7f, 0.0f, 5.9f),
            new Vector3f(-0.8f, 0.0f, 5.9f),
            new Vector3f(-0.9f, 0.0f, 5.9f),
            new Vector3f(-1.0f, 0.0f, 5.9f),
            new Vector3f(-1.1f, 0.0f, 5.9f),
            new Vector3f(-1.19f, 0.0f, 5.9f),
            new Vector3f(-1.2f, 0.0f, 5.8f),
            new Vector3f(-1.2f, 0.0f, 5.7f),
            new Vector3f(-1.2f, 0.0f, 5.6f),
            new Vector3f(-1.2f, 0.0f, 5.5f),
            new Vector3f(-1.2f, 0.0f, 5.4f),
            new Vector3f(-1.2f, 0.0f, 5.3f),
            new Vector3f(-1.2f, 0.0f, 5.2f),
            new Vector3f(-1.2f, 0.0f, 5.1f),
            new Vector3f(-1.2f, 0.0f, 5.0f),
            new Vector3f(-1.2f, 0.0f, 4.9f),
            new Vector3f(-1.2f, 0.0f, 4.7f),
            new Vector3f(-1.2f, 0.0f, 4.8f),
            new Vector3f(-1.2f, 0.0f, 4.6f),
            new Vector3f(-1.2f, 0.0f, 4.5f),
            new Vector3f(-1.2f, 0.0f, 4.4f),
            new Vector3f(-1.2f, 0.0f, 4.3f),
            new Vector3f(-1.2f, 0.0f, 4.2f),
            new Vector3f(-1.2f, 0.0f, 4.1f),
            new Vector3f(-1.2f, 0.0f, 4.0f),
            new Vector3f(-1.2f, 0.0f, 3.9f),
            new Vector3f(-1.2f, 0.0f, 3.8f),
            new Vector3f(-1.2f, 0.0f, 3.7f),
            new Vector3f(-1.2f, 0.0f, 3.6f),
            new Vector3f(-1.2f, 0.0f, 3.5f),
            new Vector3f(-1.2f, 0.0f, 3.4f),
            new Vector3f(-1.2f, 0.0f, 3.3f),
            new Vector3f(-1.2f, 0.0f, 3.2f),
            new Vector3f(-1.2f, 0.0f, 3.1f),
            new Vector3f(-1.2f, 0.0f, 3.0f),
            new Vector3f(-1.2f, 0.0f, 2.9f),
            new Vector3f(-1.2f, 0.0f, 2.8f),
            new Vector3f(-1.2f, 0.0f, 2.7f),
            new Vector3f(-1.2f, 0.0f, 2.6f),
            new Vector3f(-1.2f, 0.0f, 2.5f),
            new Vector3f(-1.2f, 0.0f, 2.4f),
            new Vector3f(-1.2f, 0.0f, 2.3f),
            new Vector3f(-1.2f, 0.0f, 2.2f),
            new Vector3f(-1.2f, 0.0f, 2.1f),
            new Vector3f(-1.2f, 0.0f, 2.0f),
            new Vector3f(-1.2f, 0.0f, 1.9f),
            new Vector3f(-1.2f, 0.0f, 1.8f),
            new Vector3f(-1.2f, 0.0f, 1.7f),
            new Vector3f(-1.2f, 0.0f, 1.6f),
            new Vector3f(-1.2f, 0.0f, 1.5f),
            new Vector3f(-1.2f, 0.0f, 1.4f),
            new Vector3f(-1.2f, 0.0f, 1.3f),
            new Vector3f(-1.2f, 0.0f, 1.2f),
            new Vector3f(-1.2f, 0.0f, 1.1f),
            new Vector3f(-1.2f, 0.0f, 1.0f),
            new Vector3f(-1.2f, 0.0f, 7.6f),
            new Vector3f(-1.1f, 0.0f, 7.6f),
            new Vector3f(-1.0f, 0.0f, 7.6f),
            new Vector3f(-0.9f, 0.0f, 7.6f),
            new Vector3f(-0.8f, 0.0f, 7.6f),
            new Vector3f(-0.7f, 0.0f, 7.6f),
            new Vector3f(-0.6f, 0.0f, 7.6f),
            new Vector3f(-0.5f, 0.0f, 7.6f),
            new Vector3f(-0.4f, 0.0f, 7.6f),
            new Vector3f(-0.3f, 0.0f, 7.6f),
            new Vector3f(-0.2f, 0.0f, 7.6f),
            new Vector3f(-0.1f, 0.0f, 7.6f),
            new Vector3f(0.0f, 0.0f, 7.6f),
            new Vector3f(0.1f, 0.0f, 7.6f),
            new Vector3f(0.2f, 0.0f, 7.6f),
            new Vector3f(0.3f, 0.0f, 7.6f),
            new Vector3f(0.4f, 0.0f, 7.6f),
            new Vector3f(0.5f, 0.0f, 7.6f),
            new Vector3f(0.6f, 0.0f, 7.6f),
            new Vector3f(0.7f, 0.0f, 7.6f),
            new Vector3f(0.8f, 0.0f, 7.6f),
            new Vector3f(0.9f, 0.0f, 7.6f),
            new Vector3f(1.0f, 0.0f, 7.6f),
            new Vector3f(1.1f, 0.0f, 7.6f),
            new Vector3f(1.2f, 0.0f, 7.6f),
            new Vector3f(1.3f, 0.0f, 7.6f),
            new Vector3f(1.4f, 0.0f, 7.6f),
            new Vector3f(1.5f, 0.0f, 7.6f),
            new Vector3f(1.6f, 0.0f, 7.6f),
            new Vector3f(1.7f, 0.0f, 7.6f),
            new Vector3f(1.8f, 0.0f, 7.6f),
            new Vector3f(1.9f, 0.0f, 7.6f),
            new Vector3f(2.0f, 0.0f, 7.6f),
            new Vector3f(2.1f, 0.0f, 7.6f),
            new Vector3f(2.2f, 0.0f, 7.6f),
            new Vector3f(2.3f, 0.0f, 7.6f),
            new Vector3f(2.4f, 0.0f, 7.6f),
            new Vector3f(2.5f, 0.0f, 7.6f),
            new Vector3f(2.6f, 0.0f, 7.6f),
            new Vector3f(2.7f, 0.0f, 7.6f),
            new Vector3f(2.8f, 0.0f, 7.6f),
            new Vector3f(2.9f, 0.0f, 7.6f),
            new Vector3f(3.0f, 0.0f, 7.6f),
            new Vector3f(3.1f, 0.0f, 7.6f),
            new Vector3f(3.2f, 0.0f, 7.6f),
            new Vector3f(3.3f, 0.0f, 7.6f),
            new Vector3f(3.4f, 0.0f, 7.6f),
            new Vector3f(3.5f, 0.0f, 7.6f),
            new Vector3f(3.6f, 0.0f, 7.6f),
            new Vector3f(3.7f, 0.0f, 7.6f),
            new Vector3f(3.8f, 0.0f, 7.6f),
            new Vector3f(3.9f, 0.0f, 7.6f),
            new Vector3f(4.0f, 0.0f, 7.6f),
            new Vector3f(4.1f, 0.0f, 7.6f),
            new Vector3f(4.0f, 0.0f, 7.6f),
            new Vector3f(4.0f, 0.0f, 7.7f),
            new Vector3f(4.0f, 0.0f, 7.8f),
            new Vector3f(4.0f, 0.0f, 7.9f),
            new Vector3f(4.0f, 0.0f, 8.0f),
            new Vector3f(4.0f, 0.0f, 8.1f),
            new Vector3f(4.0f, 0.0f, 8.2f),
            new Vector3f(4.0f, 0.0f, 8.3f),
            new Vector3f(4.0f, 0.0f, 8.4f),
            new Vector3f(4.0f, 0.0f, 8.5f),
            new Vector3f(4.0f, 0.0f, 8.6f),
            new Vector3f(4.0f, 0.0f, 8.7f),
            new Vector3f(4.0f, 0.0f, 8.8f),
            new Vector3f(4.0f, 0.0f, 8.9f),
            new Vector3f(4.0f, 0.0f, 9.0f),
            new Vector3f(4.0f, 0.0f, 9.1f),
            new Vector3f(4.1f, 0.0f, 9.1f),
            new Vector3f(3.9f, 0.0f, 9.1f),
            new Vector3f(3.8f, 0.0f, 9.1f),
            new Vector3f(3.7f, 0.0f, 9.1f),
            new Vector3f(3.6f, 0.0f, 9.1f),
            new Vector3f(3.5f, 0.0f, 9.1f),
            new Vector3f(3.4f, 0.0f, 9.1f),
            new Vector3f(3.3f, 0.0f, 9.1f),
            new Vector3f(3.2f, 0.0f, 9.1f),
            new Vector3f(3.1f, 0.0f, 9.1f),
            new Vector3f(3.0f, 0.0f, 9.1f),
            new Vector3f(2.9f, 0.0f, 9.1f),
            new Vector3f(2.8f, 0.0f, 9.1f),
            new Vector3f(2.7f, 0.0f, 9.1f),
            new Vector3f(2.6f, 0.0f, 9.1f),
            new Vector3f(2.5f, 0.0f, 9.1f),
            new Vector3f(2.4f, 0.0f, 9.1f),
            new Vector3f(2.3f, 0.0f, 9.1f),
            new Vector3f(2.2f, 0.0f, 9.1f),
            new Vector3f(2.1f, 0.0f, 9.1f),
            new Vector3f(2.0f, 0.0f, 9.1f),
            new Vector3f(1.9f, 0.0f, 9.1f),
            new Vector3f(1.8f, 0.0f, 9.1f),
            new Vector3f(1.7f, 0.0f, 9.1f),
            new Vector3f(1.6f, 0.0f, 9.1f),
            new Vector3f(1.5f, 0.0f, 9.1f),
            new Vector3f(1.4f, 0.0f, 9.1f),
            new Vector3f(1.3f, 0.0f, 9.1f),
            new Vector3f(1.2f, 0.0f, 9.1f),
            new Vector3f(1.1f, 0.0f, 9.1f),
            new Vector3f(1.0f, 0.0f, 9.1f),
            new Vector3f(0.9f, 0.0f, 9.1f),
            new Vector3f(0.8f, 0.0f, 9.1f),
            new Vector3f(0.7f, 0.0f, 9.1f),
            new Vector3f(0.3f, 0.0f, 3.7f),
            new Vector3f(0.3f, 0.0f, 3.6f),
            new Vector3f(0.3f, 0.0f, 3.5f),
            new Vector3f(0.3f, 0.0f, 3.4f),
            new Vector3f(0.3f, 0.0f, 3.3f),
            new Vector3f(0.3f, 0.0f, 3.2f),
            new Vector3f(0.3f, 0.0f, 3.1f),
            new Vector3f(0.3f, 0.0f, 3.0f),
            new Vector3f(0.3f, 0.0f, 2.9f),
            new Vector3f(0.3f, 0.0f, 2.8f),
            new Vector3f(0.3f, 0.0f, 2.7f),
            new Vector3f(0.3f, 0.0f, 2.6f),
            new Vector3f(0.3f, 0.0f, 2.5f),
            new Vector3f(0.3f, 0.0f, 2.4f),
            new Vector3f(0.3f, 0.0f, 2.3f),
            new Vector3f(0.3f, 0.0f, 2.2f),
            new Vector3f(0.3f, 0.0f, 2.1f),
            new Vector3f(0.3f, 0.0f, 2.0f),
            new Vector3f(0.3f, 0.0f, 1.9f),
            new Vector3f(0.3f, 0.0f, 1.8f),
            new Vector3f(0.3f, 0.0f, 1.7f),
            new Vector3f(0.3f, 0.0f, 1.6f),
            new Vector3f(0.3f, 0.0f, 1.5f),
            new Vector3f(0.3f, 0.0f, 1.4f),
            new Vector3f(0.3f, 0.0f, 1.3f),
            new Vector3f(0.3f, 0.0f, 1.2f),
            new Vector3f(0.3f, 0.0f, 1.1f),
            new Vector3f(0.3f, 0.0f, 1.0f),
            new Vector3f(0.3f, 0.0f, 0.9f),
            new Vector3f(0.3f, 0.0f, 0.8f),
            new Vector3f(0.3f, 0.0f, 0.7f),
            new Vector3f(0.3f, 0.0f, 0.6f),
            new Vector3f(0.3f, 0.0f, 0.5f),
            new Vector3f(0.3f, 0.0f, 0.4f),
            new Vector3f(0.3f, 0.0f, 0.3f),
            new Vector3f(0.3f, 0.0f, 0.2f),
            new Vector3f(0.3f, 0.0f, 0.1f),
            new Vector3f(0.3f, 0.0f, 0.0f),
            new Vector3f(0.3f, 0.0f, -0.1f),
            new Vector3f(0.3f, 0.0f, -0.2f),
            new Vector3f(0.3f, 0.0f, -0.3f),
            new Vector3f(0.3f, 0.0f, -0.4f),
            new Vector3f(0.3f, 0.0f, -0.5f),
            new Vector3f(0.3f, 0.0f, -0.6f),
            new Vector3f(0.3f, 0.0f, -0.7f),
            new Vector3f(0.3f, 0.0f, -0.8f),
            new Vector3f(0.3f, 0.0f, -0.9f),
            new Vector3f(0.3f, 0.0f, -1.0f),
            new Vector3f(0.3f, 0.0f, -1.1f),
            new Vector3f(0.3f, 0.0f, -1.2f),
            new Vector3f(0.3f, 0.0f, -1.3f),
            new Vector3f(0.3f, 0.0f, -1.4f),
            new Vector3f(0.3f, 0.0f, -1.5f),
            new Vector3f(0.3f, 0.0f, -1.6f),
            new Vector3f(0.3f, 0.0f, -1.7f),
            new Vector3f(0.3f, 0.0f, -1.8f),
            new Vector3f(0.3f, 0.0f, -1.9f),
            new Vector3f(0.3f, 0.0f, -2.0f),
            new Vector3f(0.3f, 0.0f, -2.1f),
            new Vector3f(0.3f, 0.0f, -2.2f),
            new Vector3f(0.3f, 0.0f, -2.3f),
            new Vector3f(0.3f, 0.0f, -2.4f),
            new Vector3f(0.3f, 0.0f, -2.5f),
            new Vector3f(-1.2f, 0.0f, 1.7f),
            new Vector3f(-1.2f, 0.0f, 1.6f),
            new Vector3f(-1.2f, 0.0f, 1.5f),
            new Vector3f(-1.2f, 0.0f, 1.4f),
            new Vector3f(-1.2f, 0.0f, 1.3f),
            new Vector3f(-1.2f, 0.0f, 1.2f),
            new Vector3f(-1.2f, 0.0f, 1.1f),
            new Vector3f(-1.2f, 0.0f, 1.0f),
            new Vector3f(-1.2f, 0.0f, 0.9f),
            new Vector3f(-1.2f, 0.0f, 0.8f),
            new Vector3f(-1.2f, 0.0f, 0.7f),
            new Vector3f(-1.2f, 0.0f, 0.6f),
            new Vector3f(-1.2f, 0.0f, 0.5f),
            new Vector3f(-1.2f, 0.0f, 0.4f),
            new Vector3f(-1.2f, 0.0f, 0.3f),
            new Vector3f(-1.2f, 0.0f, 0.2f),
            new Vector3f(-1.2f, 0.0f, 0.1f),
            new Vector3f(-1.2f, 0.0f, 0.0f),
            new Vector3f(-1.2f, 0.0f, -0.1f),
            new Vector3f(-1.2f, 0.0f, -0.2f),
            new Vector3f(-1.2f, 0.0f, -0.3f),
            new Vector3f(-1.2f, 0.0f, -0.4f),
            new Vector3f(-1.2f, 0.0f, -0.5f),
            new Vector3f(-1.2f, 0.0f, -0.6f),
            new Vector3f(-1.2f, 0.0f, -0.7f),
            new Vector3f(-1.2f, 0.0f, -0.8f),
            new Vector3f(-1.2f, 0.0f, -0.9f),
            new Vector3f(-1.2f, 0.0f, -1.0f),
            new Vector3f(-1.2f, 0.0f, -1.1f),
            new Vector3f(-1.2f, 0.0f, -1.2f),
            new Vector3f(-1.2f, 0.0f, -1.3f),
            new Vector3f(-1.2f, 0.0f, -1.4f),
            new Vector3f(-1.2f, 0.0f, -1.5f),
            new Vector3f(-1.2f, 0.0f, -1.6f),
            new Vector3f(-1.2f, 0.0f, -1.7f),
            new Vector3f(-1.2f, 0.0f, -1.8f),
            new Vector3f(-1.2f, 0.0f, -1.9f),
            new Vector3f(-1.2f, 0.0f, -2.0f),
            new Vector3f(-1.2f, 0.0f, -2.1f),
            new Vector3f(-1.2f, 0.0f, -2.2f),
            new Vector3f(-1.2f, 0.0f, -2.3f),
            new Vector3f(-1.2f, 0.0f, -2.4f),
            new Vector3f(-1.2f, 0.0f, -2.5f),
            new Vector3f(-1.2f, 0.0f, -2.6f),
            new Vector3f(-1.2f, 0.0f, -2.7f),
            new Vector3f(-1.2f, 0.0f, -2.8f),
            new Vector3f(-1.2f, 0.0f, -2.9f),
            new Vector3f(-1.2f, 0.0f, -3.0f),
            new Vector3f(-1.2f, 0.0f, -3.1f),
            new Vector3f(-1.2f, 0.0f, -3.2f),
            new Vector3f(-1.2f, 0.0f, -3.3f),
            new Vector3f(-1.2f, 0.0f, -3.4f),
            new Vector3f(-2.87f, 0.0f, 1.7f),
            new Vector3f(-2.87f, 0.0f, 1.6f),
            new Vector3f(-2.87f, 0.0f, 1.5f),
            new Vector3f(-2.87f, 0.0f, 1.4f),
            new Vector3f(-2.87f, 0.0f, 1.3f),
            new Vector3f(-2.87f, 0.0f, 1.2f),
            new Vector3f(-2.87f, 0.0f, 1.1f),
            new Vector3f(-2.87f, 0.0f, 1.0f),
            new Vector3f(-2.87f, 0.0f, 0.9f),
            new Vector3f(-2.87f, 0.0f, 0.8f),
            new Vector3f(-2.87f, 0.0f, 0.7f),
            new Vector3f(-2.87f, 0.0f, 0.6f),
            new Vector3f(-2.87f, 0.0f, 0.5f),
            new Vector3f(-2.87f, 0.0f, 0.4f),
            new Vector3f(-2.87f, 0.0f, 0.3f),
            new Vector3f(-2.87f, 0.0f, 0.2f),
            new Vector3f(-2.87f, 0.0f, 0.1f),
            new Vector3f(-2.87f, 0.0f, 0.0f),
            new Vector3f(-2.87f, 0.0f, -0.1f),
            new Vector3f(-2.87f, 0.0f, -0.2f),
            new Vector3f(-2.87f, 0.0f, -0.3f),
            new Vector3f(-2.87f, 0.0f, -0.4f),
            new Vector3f(-2.87f, 0.0f, -0.5f),
            new Vector3f(-2.87f, 0.0f, -0.6f),
            new Vector3f(-2.87f, 0.0f, -0.7f),
            new Vector3f(-2.87f, 0.0f, -0.8f),
            new Vector3f(-2.87f, 0.0f, -0.9f),
            new Vector3f(-2.87f, 0.0f, -1.0f),
            new Vector3f(-2.87f, 0.0f, -1.1f),
            new Vector3f(-2.87f, 0.0f, -1.2f),
            new Vector3f(-2.87f, 0.0f, -1.3f),
            new Vector3f(-2.87f, 0.0f, -1.4f),
            new Vector3f(-2.87f, 0.0f, -1.5f),
            new Vector3f(-2.87f, 0.0f, -1.6f),
            new Vector3f(-2.87f, 0.0f, -1.7f),
            new Vector3f(-2.87f, 0.0f, -1.8f),
            new Vector3f(-2.87f, 0.0f, -1.9f),
            new Vector3f(-2.87f, 0.0f, -2.0f),
            new Vector3f(-2.87f, 0.0f, -2.1f),
            new Vector3f(-2.87f, 0.0f, -2.2f),
            new Vector3f(-2.87f, 0.0f, -2.3f),
            new Vector3f(-2.87f, 0.0f, -2.4f),
            new Vector3f(-2.87f, 0.0f, -2.5f),
            new Vector3f(-2.87f, 0.0f, -2.6f),
            new Vector3f(-2.87f, 0.0f, -2.7f),
            new Vector3f(-2.87f, 0.0f, -2.8f),
            new Vector3f(-2.87f, 0.0f, -2.9f),
            new Vector3f(-2.87f, 0.0f, -3.0f),
            new Vector3f(-2.87f, 0.0f, -3.1f),
            new Vector3f(-2.87f, 0.0f, -3.2f),
            new Vector3f(-2.87f, 0.0f, -3.3f),
            new Vector3f(-2.87f, 0.0f, -3.4f),
            new Vector3f(-2.87f, 0.0f, 5.8f),
            new Vector3f(-2.87f, 0.0f, 5.7f),
            new Vector3f(-2.87f, 0.0f, 5.6f),
            new Vector3f(-2.87f, 0.0f, 5.5f),
            new Vector3f(-2.87f, 0.0f, 5.4f),
            new Vector3f(-2.87f, 0.0f, 5.3f),
            new Vector3f(-2.87f, 0.0f, 5.2f),
            new Vector3f(-2.87f, 0.0f, 5.1f),
            new Vector3f(-2.87f, 0.0f, 5.0f),
            new Vector3f(-2.87f, 0.0f, 4.9f),
            new Vector3f(-2.87f, 0.0f, 4.7f),
            new Vector3f(-2.87f, 0.0f, 4.8f),
            new Vector3f(-2.87f, 0.0f, 4.6f),
            new Vector3f(-2.87f, 0.0f, 4.5f),
            new Vector3f(-2.87f, 0.0f, 4.4f),
            new Vector3f(-2.87f, 0.0f, 4.3f),
            new Vector3f(-2.87f, 0.0f, 4.2f),
            new Vector3f(-2.87f, 0.0f, 4.1f),
            new Vector3f(-2.87f, 0.0f, 4.0f),
            new Vector3f(-2.87f, 0.0f, 3.9f),
            new Vector3f(-2.87f, 0.0f, 3.8f),
            new Vector3f(-2.87f, 0.0f, 3.7f),
            new Vector3f(-2.87f, 0.0f, 3.6f),
            new Vector3f(-2.87f, 0.0f, 3.5f),
            new Vector3f(-2.87f, 0.0f, 3.4f),
            new Vector3f(-2.87f, 0.0f, 3.3f),
            new Vector3f(-2.87f, 0.0f, 3.2f),
            new Vector3f(-2.87f, 0.0f, 3.1f),
            new Vector3f(-2.87f, 0.0f, 3.0f),
            new Vector3f(-2.87f, 0.0f, 2.9f),
            new Vector3f(-2.87f, 0.0f, 2.8f),
            new Vector3f(-2.87f, 0.0f, 2.7f),
            new Vector3f(-2.87f, 0.0f, 2.6f),
            new Vector3f(-2.87f, 0.0f, 2.5f),
            new Vector3f(-2.87f, 0.0f, 2.4f),
            new Vector3f(-2.87f, 0.0f, 2.3f),
            new Vector3f(-2.87f, 0.0f, 2.2f),
            new Vector3f(-2.87f, 0.0f, 2.1f),
            new Vector3f(-2.87f, 0.0f, 2.0f),
            new Vector3f(-2.87f, 0.0f, 1.9f),
            new Vector3f(-2.87f, 0.0f, 1.8f),
            new Vector3f(-2.87f, 0.0f, 1.7f),
            new Vector3f(-2.87f, 0.0f, 1.6f),
            new Vector3f(-2.87f, 0.0f, 1.5f),
            new Vector3f(-2.87f, 0.0f, 1.4f),
            new Vector3f(-2.87f, 0.0f, 1.3f),
            new Vector3f(-2.87f, 0.0f, 1.2f),
            new Vector3f(-2.87f, 0.0f, 1.1f),
            new Vector3f(-2.87f, 0.0f, 1.0f),
            new Vector3f(-2.87f, 0.0f, 5.9f),
            new Vector3f(-2.87f, 0.0f, 6.0f),
            new Vector3f(-2.87f, 0.0f, 6.1f),
            new Vector3f(-2.87f, 0.0f, 6.2f),
            new Vector3f(-2.87f, 0.0f, 6.3f),
            new Vector3f(-2.87f, 0.0f, 6.4f),
            new Vector3f(-2.87f, 0.0f, 6.5f),
            new Vector3f(-2.87f, 0.0f, 6.6f),
            new Vector3f(-2.87f, 0.0f, 6.7f),
            new Vector3f(-2.87f, 0.0f, 6.8f),
            new Vector3f(-2.87f, 0.0f, 6.9f),
            new Vector3f(-2.87f, 0.0f, 7.0f),
            new Vector3f(-2.87f, 0.0f, 7.1f),
            new Vector3f(-2.87f, 0.0f, 7.2f),
            new Vector3f(-2.87f, 0.0f, 7.3f),
            new Vector3f(-2.87f, 0.0f, 7.4f),
            new Vector3f(-2.87f, 0.0f, 7.5f),
            new Vector3f(-2.87f, 0.0f, 7.6f),
            new Vector3f(-2.87f, 0.0f, 7.7f),
            new Vector3f(-2.87f, 0.0f, 7.8f),
            new Vector3f(-2.87f, 0.0f, 7.9f),
            new Vector3f(-2.87f, 0.0f, 8.0f),
            new Vector3f(-2.87f, 0.0f, 8.1f),
            new Vector3f(-2.87f, 0.0f, 8.2f),
            new Vector3f(-2.87f, 0.0f, 8.3f),
            new Vector3f(-2.87f, 0.0f, 8.4f),
            new Vector3f(-2.87f, 0.0f, 8.5f),
            new Vector3f(-2.87f, 0.0f, 8.6f),
            new Vector3f(-2.87f, 0.0f, 8.7f),
            new Vector3f(-2.87f, 0.0f, 8.8f),
            new Vector3f(-2.87f, 0.0f, 8.9f),
            new Vector3f(-2.87f, 0.0f, 9.0f),
            new Vector3f(-2.87f, 0.0f, 9.1f),
            new Vector3f(-2.87f, 0.0f, 9.2f),
            new Vector3f(-2.87f, 0.0f, 9.3f),
            new Vector3f(-2.87f, 0.0f, 9.4f),
            new Vector3f(-2.87f, 0.0f, 9.5f),
            new Vector3f(-2.87f, 0.0f, 9.6f),
            new Vector3f(-2.87f, 0.0f, 9.7f),
            new Vector3f(-2.87f, 0.0f, 9.8f),
            new Vector3f(-2.87f, 0.0f, 9.9f),
            new Vector3f(-2.87f, 0.0f, 10.0f),
            new Vector3f(-2.87f, 0.0f, 10.1f),
            new Vector3f(-2.87f, 0.0f, 10.2f),
            new Vector3f(-2.87f, 0.0f, 10.3f),
            new Vector3f(-2.87f, 0.0f, 10.4f),
            new Vector3f(-2.87f, 0.0f, 10.5f),
            new Vector3f(-2.87f, 0.0f, 10.6f),
            new Vector3f(-2.87f, 0.0f, 10.7f),
            new Vector3f(-2.87f, 0.0f, 10.8f),
            new Vector3f(-2.87f, 0.0f, 10.9f),
            new Vector3f(-2.87f, 0.0f, 11.0f),
            new Vector3f(-2.87f, 0.0f, 11.1f),
            new Vector3f(-2.87f, 0.0f, 11.2f),
            new Vector3f(-2.87f, 0.0f, 11.3f),
            new Vector3f(-2.87f, 0.0f, 11.4f),
            new Vector3f(-2.87f, 0.0f, 11.5f),
            new Vector3f(-2.87f, 0.0f, 11.6f),
            new Vector3f(-2.87f, 0.0f, 11.7f),
            new Vector3f(-2.87f, 0.0f, 11.8f),
            new Vector3f(-2.87f, 0.0f, 11.9f),
            new Vector3f(-2.87f, 0.0f, 12.0f),
            new Vector3f(-2.87f, 0.0f, 12.1f),
            new Vector3f(-2.87f, 0.0f, 12.2f),
            new Vector3f(-2.87f, 0.0f, 12.3f),
            new Vector3f(-2.87f, 0.0f, 12.4f),
            new Vector3f(-2.87f, 0.0f, 12.5f),
            new Vector3f(-2.87f, 0.0f, 12.6f),
            new Vector3f(-2.87f, 0.0f, 12.7f),
            new Vector3f(-2.87f, 0.0f, 12.8f),
            new Vector3f(-2.87f, 0.0f, 12.9f),
            new Vector3f(-2.87f, 0.0f, 13.0f),
            new Vector3f(-2.87f, 0.0f, 13.1f),
            new Vector3f(-2.87f, 0.0f, 13.2f),
            new Vector3f(-2.87f, 0.0f, 13.3f),
            new Vector3f(-2.87f, 0.0f, 13.4f),
            new Vector3f(-2.87f, 0.0f, 13.5f),
            new Vector3f(-2.87f, 0.0f, 13.6f),
            new Vector3f(-2.87f, 0.0f, 13.7f),
            new Vector3f(-2.87f, 0.0f, 13.8f),
            new Vector3f(-2.87f, 0.0f, 13.9f),
            new Vector3f(-1.2f, 0.0f, 7.5f),
            new Vector3f(-1.2f, 0.0f, 7.6f),
            new Vector3f(-1.2f, 0.0f, 7.7f),
            new Vector3f(-1.2f, 0.0f, 7.8f),
            new Vector3f(-1.2f, 0.0f, 7.9f),
            new Vector3f(-1.2f, 0.0f, 8.0f),
            new Vector3f(-1.2f, 0.0f, 8.1f),
            new Vector3f(-1.2f, 0.0f, 8.2f),
            new Vector3f(-1.2f, 0.0f, 8.3f),
            new Vector3f(-1.2f, 0.0f, 8.4f),
            new Vector3f(-1.2f, 0.0f, 8.5f),
            new Vector3f(-1.2f, 0.0f, 8.6f),
            new Vector3f(-1.2f, 0.0f, 8.7f),
            new Vector3f(-1.2f, 0.0f, 8.8f),
            new Vector3f(-1.2f, 0.0f, 8.9f),
            new Vector3f(-1.2f, 0.0f, 9.0f),
            new Vector3f(-1.2f, 0.0f, 9.1f),
            new Vector3f(-1.2f, 0.0f, 9.2f),
            new Vector3f(-1.2f, 0.0f, 9.3f),
            new Vector3f(-1.2f, 0.0f, 9.4f),
            new Vector3f(-1.2f, 0.0f, 9.5f),
            new Vector3f(-1.2f, 0.0f, 9.6f),
            new Vector3f(-1.2f, 0.0f, 9.7f),
            new Vector3f(-1.2f, 0.0f, 9.8f),
            new Vector3f(-1.2f, 0.0f, 9.9f),
            new Vector3f(-1.2f, 0.0f, 10.0f),
            new Vector3f(-1.2f, 0.0f, 10.1f),
            new Vector3f(-1.2f, 0.0f, 10.2f),
            new Vector3f(-1.2f, 0.0f, 10.3f),
            new Vector3f(-1.2f, 0.0f, 10.4f),
            new Vector3f(-1.2f, 0.0f, 10.5f),
            new Vector3f(-1.2f, 0.0f, 10.6f),
            new Vector3f(-1.2f, 0.0f, 10.7f),
            new Vector3f(-1.2f, 0.0f, 10.8f),
            new Vector3f(-1.2f, 0.0f, 10.9f),
            new Vector3f(-1.2f, 0.0f, 11.0f),
            new Vector3f(-1.2f, 0.0f, 11.1f),
            new Vector3f(-1.2f, 0.0f, 11.2f),
            new Vector3f(-1.2f, 0.0f, 11.3f),
            new Vector3f(-1.2f, 0.0f, 11.4f),
            new Vector3f(-1.2f, 0.0f, 11.5f),
            new Vector3f(-1.2f, 0.0f, 11.6f),
            new Vector3f(-1.2f, 0.0f, 11.7f),
            new Vector3f(-1.2f, 0.0f, 11.8f),
            new Vector3f(-1.2f, 0.0f, 11.9f),
            new Vector3f(-1.2f, 0.0f, 12.0f),
            new Vector3f(-1.2f, 0.0f, 12.1f),
            new Vector3f(-1.2f, 0.0f, 12.2f),
            new Vector3f(-1.2f, 0.0f, 12.3f),
            new Vector3f(-1.2f, 0.0f, 12.4f),
            new Vector3f(-1.2f, 0.0f, 12.5f),
            new Vector3f(-1.2f, 0.0f, 12.6f),
            new Vector3f(-1.2f, 0.0f, 12.7f),
            new Vector3f(-1.2f, 0.0f, 12.8f),
            new Vector3f(-1.2f, 0.0f, 12.9f),
            new Vector3f(-1.2f, 0.0f, 13.0f),
            new Vector3f(-1.2f, 0.0f, 13.1f),
            new Vector3f(-1.2f, 0.0f, 13.2f),
            new Vector3f(-1.2f, 0.0f, 13.3f),
            new Vector3f(-1.2f, 0.0f, 13.4f),
            new Vector3f(-1.2f, 0.0f, 13.5f),
            new Vector3f(-1.2f, 0.0f, 13.6f),
            new Vector3f(-1.2f, 0.0f, 13.7f),
            new Vector3f(-1.2f, 0.0f, 13.8f),
            new Vector3f(-1.2f, 0.0f, 13.9f),
            new Vector3f(-1.9f, 0.0f, 14.5f),
            new Vector3f(-1.8f, 0.0f, 14.5f),
            new Vector3f(-1.7f, 0.0f, 14.5f),
            new Vector3f(-1.6f, 0.0f, 14.5f),
            new Vector3f(-2.0f, 0.0f, 14.5f),
            new Vector3f(-2.1f, 0.0f, 14.5f),
            new Vector3f(-2.2f, 0.0f, 14.5f),
            new Vector3f(-2.3f, 0.0f, 14.5f),
            new Vector3f(-2.0f, 0.0f, 14.5f),
            new Vector3f(0.7f, 0.0f, 4.2f),
            new Vector3f(0.3f, 0.0f, 3.9f),
            new Vector3f(0.5f, 0.0f, 4.1f),
            new Vector3f(-14.3f, 0.0f, 6.6f),
            new Vector3f(-14.3f, 0.0f, 6.7f),
            new Vector3f(-14.3f, 0.0f, 6.8f),
            new Vector3f(-14.3f, 0.0f, 6.9f),
            new Vector3f(-14.3f, 0.0f, 7.0f),
            new Vector3f(-14.3f, 0.0f, 7.1f),
            new Vector3f(-14.3f, 0.0f, 7.2f),
            new Vector3f(-14.3f, 0.0f, 7.3f),
            new Vector3f(-14.3f, 0.0f, 7.4f),
            new Vector3f(-14.3f, 0.0f, 7.5f),
            new Vector3f(-14.3f, 0.0f, 7.6f),
            new Vector3f(-14.3f, 0.0f, 7.7f),
            new Vector3f(-14.3f, 0.0f, 7.8f),
            new Vector3f(-14.3f, 0.0f, 7.9f),
            new Vector3f(-14.3f, 0.0f, 8.0f),
            new Vector3f(-14.3f, 0.0f, 8.1f),
            new Vector3f(-14.3f, 0.0f, 8.2f),
            new Vector3f(-14.3f, 0.0f, 8.3f),
            new Vector3f(-14.3f, 0.0f, 8.4f),
            new Vector3f(-14.3f, 0.0f, 8.5f),
            new Vector3f(-14.3f, 0.0f, 8.6f),
            new Vector3f(-14.3f, 0.0f, 8.7f),
            new Vector3f(-14.3f, 0.0f, 8.8f),
            new Vector3f(-14.3f, 0.0f, 8.9f),
            new Vector3f(-14.3f, 0.0f, 9.0f),
            new Vector3f(-14.3f, 0.0f, 9.1f),
            new Vector3f(-14.3f, 0.0f, 9.2f),
            new Vector3f(-14.3f, 0.0f, 9.3f),
            new Vector3f(-14.3f, 0.0f, 9.4f),
            new Vector3f(-14.3f, 0.0f, 9.5f),
            new Vector3f(-14.3f, 0.0f, 9.6f),
            new Vector3f(-14.3f, 0.0f, 9.7f),
            new Vector3f(-14.3f, 0.0f, 9.8f),
            new Vector3f(-14.3f, 0.0f, 9.9f),
            new Vector3f(-14.3f, 0.0f, 10.0f),
            new Vector3f(-14.3f, 0.0f, 10.1f),
            new Vector3f(-14.3f, 0.0f, 10.2f),
            new Vector3f(-14.3f, 0.0f, 10.3f),
            new Vector3f(-14.3f, 0.0f, 10.4f),
            new Vector3f(-14.3f, 0.0f, 10.5f),
            new Vector3f(-14.3f, 0.0f, 10.6f),
            new Vector3f(-14.3f, 0.0f, 10.7f),
            new Vector3f(-14.3f, 0.0f, 10.8f),
            new Vector3f(-14.3f, 0.0f, 10.9f),
            new Vector3f(-14.3f, 0.0f, 11.0f),
            new Vector3f(-14.3f, 0.0f, 11.1f),
            new Vector3f(-14.3f, 0.0f, 11.2f),
            new Vector3f(-14.3f, 0.0f, 11.3f),
            new Vector3f(-14.3f, 0.0f, 11.4f),
            new Vector3f(-14.3f, 0.0f, 11.5f),
            new Vector3f(-14.3f, 0.0f, 11.6f),
            new Vector3f(-14.3f, 0.0f, 11.7f),
            new Vector3f(-14.3f, 0.0f, 11.8f),
            new Vector3f(-14.3f, 0.0f, 11.9f),
            new Vector3f(-14.3f, 0.0f, 12.0f),
            new Vector3f(-14.3f, 0.0f, 12.1f),
            new Vector3f(-14.3f, 0.0f, 12.2f),
            new Vector3f(-14.3f, 0.0f, 12.3f),
            new Vector3f(-14.3f, 0.0f, 12.4f),
            new Vector3f(-14.3f, 0.0f, 12.5f),
            new Vector3f(-14.3f, 0.0f, 12.6f),
            new Vector3f(-14.3f, 0.0f, 12.7f),
            new Vector3f(-14.3f, 0.0f, 12.8f),
            new Vector3f(-14.3f, 0.0f, 12.9f),
            new Vector3f(-14.3f, 0.0f, 13.0f),
            new Vector3f(-14.3f, 0.0f, 13.1f),
            new Vector3f(-14.3f, 0.0f, 13.2f),
            new Vector3f(-14.3f, 0.0f, 13.3f),
            new Vector3f(-14.3f, 0.0f, 13.4f),
            new Vector3f(-14.3f, 0.0f, 13.5f),
            new Vector3f(-14.3f, 0.0f, 13.6f),
            new Vector3f(-14.3f, 0.0f, 13.7f),
            new Vector3f(-14.3f, 0.0f, 13.8f),
            new Vector3f(-14.3f, 0.0f, 13.9f),
            new Vector3f(-14.3f, 0.0f, 14.0f),
            new Vector3f(-14.3f, 0.0f, 14.1f),
            new Vector3f(-14.3f, 0.0f, 14.2f),
            new Vector3f(-14.3f, 0.0f, 14.3f),
            new Vector3f(-14.3f, 0.0f, 14.4f),
            new Vector3f(-14.3f, 0.0f, 14.5f),
            new Vector3f(-14.3f, 0.0f, 14.6f),
            new Vector3f(-14.3f, 0.0f, 14.7f),
            new Vector3f(-14.3f, 0.0f, 14.8f),
            new Vector3f(-14.3f, 0.0f, 14.9f),
            new Vector3f(-14.3f, 0.0f, 15.0f),
            new Vector3f(-14.3f, 0.0f, 15.1f),
            new Vector3f(-14.3f, 0.0f, 15.2f),
            new Vector3f(-14.3f, 0.0f, 15.3f),
            new Vector3f(-14.3f, 0.0f, 15.4f),
            new Vector3f(-14.3f, 0.0f, 15.5f),
            new Vector3f(-14.3f, 0.0f, 15.6f),
            new Vector3f(-14.3f, 0.0f, 15.7f),
            new Vector3f(-14.3f, 0.0f, 15.8f),
            new Vector3f(-14.3f, 0.0f, 15.9f),
            new Vector3f(-14.3f, 0.0f, 16.0f),
            new Vector3f(-14.3f, 0.0f, 16.1f),
            new Vector3f(-14.3f, 0.0f, 16.2f),
            new Vector3f(-19.0f, 0.0f, 16.3f),
            new Vector3f(-14.3f, 0.0f, 16.4f),
            new Vector3f(-14.3f, 0.0f, 16.5f),
            new Vector3f(-14.3f, 0.0f, 16.6f),
            new Vector3f(-12.5f, 0.0f, 6.1f),
            new Vector3f(-12.6f, 0.0f, 6.1f),
            new Vector3f(-12.7f, 0.0f, 6.1f),
            new Vector3f(-12.8f, 0.0f, 6.1f),
            new Vector3f(-12.9f, 0.0f, 6.1f),
            new Vector3f(-13.0f, 0.0f, 6.1f),
            new Vector3f(-13.1f, 0.0f, 6.1f),
            new Vector3f(-13.2f, 0.0f, 6.1f),
            new Vector3f(-13.3f, 0.0f, 6.1f),
            new Vector3f(-13.4f, 0.0f, 6.1f),
            new Vector3f(-13.5f, 0.0f, 6.1f),
            new Vector3f(-13.6f, 0.0f, 6.1f),
            new Vector3f(-13.7f, 0.0f, 6.1f),
            new Vector3f(-13.8f, 0.0f, 6.1f),
            new Vector3f(-13.9f, 0.0f, 6.1f),
            new Vector3f(-14.0f, 0.0f, 6.1f),
            new Vector3f(-14.1f, 0.0f, 6.1f),
            new Vector3f(-14.2f, 0.0f, 6.1f),
            new Vector3f(-14.2f, 0.0f, 6.2f),
            new Vector3f(-14.2f, 0.0f, 6.3f),
            new Vector3f(-19.0f, 0.0f, 6.1f),
            new Vector3f(-19.0f, 0.0f, 6.2f),
            new Vector3f(-19.0f, 0.0f, 6.3f),
            new Vector3f(-19.0f, 0.0f, 6.4f),
            new Vector3f(-19.0f, 0.0f, 6.5f),
            new Vector3f(-19.0f, 0.0f, 6.6f),
            new Vector3f(-19.0f, 0.0f, 6.7f),
            new Vector3f(-19.0f, 0.0f, 6.8f),
            new Vector3f(-19.0f, 0.0f, 6.9f),
            new Vector3f(-19.0f, 0.0f, 7.0f),
            new Vector3f(-19.0f, 0.0f, 7.1f),
            new Vector3f(-19.0f, 0.0f, 7.2f),
            new Vector3f(-19.0f, 0.0f, 7.3f),
            new Vector3f(-19.0f, 0.0f, 7.4f),
            new Vector3f(-19.0f, 0.0f, 7.5f),
            new Vector3f(-19.0f, 0.0f, 7.6f),
            new Vector3f(-19.0f, 0.0f, 7.7f),
            new Vector3f(-19.0f, 0.0f, 7.8f),
            new Vector3f(-19.0f, 0.0f, 7.9f),
            new Vector3f(-19.0f, 0.0f, 8.0f),
            new Vector3f(-19.0f, 0.0f, 8.1f),
            new Vector3f(-19.0f, 0.0f, 8.2f),
            new Vector3f(-19.0f, 0.0f, 8.3f),
            new Vector3f(-19.0f, 0.0f, 8.4f),
            new Vector3f(-19.0f, 0.0f, 8.5f),
            new Vector3f(-19.0f, 0.0f, 8.6f),
            new Vector3f(-19.0f, 0.0f, 8.7f),
            new Vector3f(-19.0f, 0.0f, 8.8f),
            new Vector3f(-19.0f, 0.0f, 8.9f),
            new Vector3f(-19.0f, 0.0f, 9.0f),
            new Vector3f(-19.0f, 0.0f, 9.1f),
            new Vector3f(-19.0f, 0.0f, 9.2f),
            new Vector3f(-19.0f, 0.0f, 9.3f),
            new Vector3f(-19.0f, 0.0f, 9.4f),
            new Vector3f(-19.0f, 0.0f, 9.5f),
            new Vector3f(-19.0f, 0.0f, 9.6f),
            new Vector3f(-19.0f, 0.0f, 9.7f),
            new Vector3f(-19.0f, 0.0f, 9.8f),
            new Vector3f(-19.0f, 0.0f, 9.9f),
            new Vector3f(-19.0f, 0.0f, 10.0f),
            new Vector3f(-19.0f, 0.0f, 10.1f),
            new Vector3f(-19.0f, 0.0f, 10.2f),
            new Vector3f(-19.0f, 0.0f, 10.3f),
            new Vector3f(-19.0f, 0.0f, 10.4f),
            new Vector3f(-19.0f, 0.0f, 10.5f),
            new Vector3f(-19.0f, 0.0f, 10.6f),
            new Vector3f(-19.0f, 0.0f, 10.7f),
            new Vector3f(-19.0f, 0.0f, 10.8f),
            new Vector3f(-19.0f, 0.0f, 10.9f),
            new Vector3f(-19.0f, 0.0f, 11.0f),
            new Vector3f(-19.0f, 0.0f, 11.1f),
            new Vector3f(-19.0f, 0.0f, 11.2f),
            new Vector3f(-19.0f, 0.0f, 11.3f),
            new Vector3f(-19.0f, 0.0f, 11.4f),
            new Vector3f(-19.0f, 0.0f, 11.5f),
            new Vector3f(-19.0f, 0.0f, 11.6f),
            new Vector3f(-19.0f, 0.0f, 11.7f),
            new Vector3f(-19.0f, 0.0f, 11.8f),
            new Vector3f(-19.0f, 0.0f, 11.9f),
            new Vector3f(-19.0f, 0.0f, 12.0f),
            new Vector3f(-19.0f, 0.0f, 12.1f),
            new Vector3f(-19.0f, 0.0f, 12.2f),
            new Vector3f(-19.0f, 0.0f, 12.3f),
            new Vector3f(-19.0f, 0.0f, 12.4f),
            new Vector3f(-19.0f, 0.0f, 12.5f),
            new Vector3f(-19.0f, 0.0f, 12.6f),
            new Vector3f(-19.0f, 0.0f, 12.7f),
            new Vector3f(-19.0f, 0.0f, 12.8f),
            new Vector3f(-19.0f, 0.0f, 12.9f),
            new Vector3f(-19.0f, 0.0f, 13.0f),
            new Vector3f(-19.0f, 0.0f, 13.1f),
            new Vector3f(-19.0f, 0.0f, 13.2f),
            new Vector3f(-19.0f, 0.0f, 13.3f),
            new Vector3f(-19.0f, 0.0f, 13.4f),
            new Vector3f(-19.0f, 0.0f, 13.5f),
            new Vector3f(-19.0f, 0.0f, 13.6f),
            new Vector3f(-19.0f, 0.0f, 13.7f),
            new Vector3f(-19.0f, 0.0f, 13.8f),
            new Vector3f(-19.0f, 0.0f, 13.9f),
            new Vector3f(-19.0f, 0.0f, 14.0f),
            new Vector3f(-19.0f, 0.0f, 14.1f),
            new Vector3f(-19.0f, 0.0f, 14.2f),
            new Vector3f(-19.0f, 0.0f, 14.3f),
            new Vector3f(-19.0f, 0.0f, 14.4f),
            new Vector3f(-19.0f, 0.0f, 14.5f),
            new Vector3f(-19.0f, 0.0f, 14.6f),
            new Vector3f(-19.0f, 0.0f, 14.7f),
            new Vector3f(-19.0f, 0.0f, 14.8f),
            new Vector3f(-19.0f, 0.0f, 14.9f),
            new Vector3f(-19.0f, 0.0f, 15.0f),
            new Vector3f(-19.0f, 0.0f, 15.1f),
            new Vector3f(-19.0f, 0.0f, 15.2f),
            new Vector3f(-19.0f, 0.0f, 15.3f),
            new Vector3f(-19.0f, 0.0f, 15.4f),
            new Vector3f(-19.0f, 0.0f, 15.5f),
            new Vector3f(-19.0f, 0.0f, 15.6f),
            new Vector3f(-19.0f, 0.0f, 15.7f),
            new Vector3f(-19.0f, 0.0f, 15.8f),
            new Vector3f(-19.0f, 0.0f, 15.9f),
            new Vector3f(-19.0f, 0.0f, 16.0f),
            new Vector3f(-19.0f, 0.0f, 16.1f),
            new Vector3f(-19.0f, 0.0f, 16.2f),
            new Vector3f(-19.0f, 0.0f, 16.3f),
            new Vector3f(-19.0f, 0.0f, 16.4f),
            new Vector3f(-19.0f, 0.0f, 16.5f),
            new Vector3f(-19.0f, 0.0f, 16.6f),
            new Vector3f(-2.55f, 0.0f, 14.4f),
            new Vector3f(-2.4f, 0.0f, 14.5f),
            new Vector3f(-2.5f, 0.0f, 14.5f),
            new Vector3f(4.8f, 0.0f, 5.9f),
            new Vector3f(4.7f, 0.0f, 5.9f),
            new Vector3f(4.6f, 0.0f, 5.9f),
            new Vector3f(5.1f, 0.0f, 6.0f),
            new Vector3f(5.3f, 0.0f, 6.3f),
            new Vector3f(5.2f, 0.0f, 6.1f),
            new Vector3f(5.0f, 0.0f, 6.0f),
            new Vector3f(0.29f, 0.0f, 9.3f),
            new Vector3f(-1.38f, 0.0f, 14.4f),
            new Vector3f(-1.48f, 0.0f, 14.4f),
            new Vector3f(-4.2f, 0.0f, -4.0f),
            new Vector3f(-4.2f, 0.0f, 1.7f),
            new Vector3f(-4.2f, 0.0f, 1.6f),
            new Vector3f(-4.2f, 0.0f, 1.5f),
            new Vector3f(-4.2f, 0.0f, 1.4f),
            new Vector3f(-4.2f, 0.0f, 1.3f),
            new Vector3f(-4.2f, 0.0f, 1.2f),
            new Vector3f(-4.2f, 0.0f, 1.1f),
            new Vector3f(-4.2f, 0.0f, 1.0f),
            new Vector3f(-4.2f, 0.0f, 0.9f),
            new Vector3f(-4.2f, 0.0f, 0.8f),
            new Vector3f(-4.2f, 0.0f, 0.7f),
            new Vector3f(-4.2f, 0.0f, 0.6f),
            new Vector3f(-4.2f, 0.0f, 0.5f),
            new Vector3f(-4.2f, 0.0f, 0.4f),
            new Vector3f(-4.2f, 0.0f, 0.3f),
            new Vector3f(-4.2f, 0.0f, 0.2f),
            new Vector3f(-4.2f, 0.0f, 0.1f),
            new Vector3f(-4.2f, 0.0f, 0.0f),
            new Vector3f(-4.2f, 0.0f, -0.1f),
            new Vector3f(-4.2f, 0.0f, -0.2f),
            new Vector3f(-4.2f, 0.0f, -0.3f),
            new Vector3f(-4.2f, 0.0f, -0.4f),
            new Vector3f(-4.2f, 0.0f, -0.5f),
            new Vector3f(-4.2f, 0.0f, -0.6f),
            new Vector3f(-4.2f, 0.0f, -0.7f),
            new Vector3f(-4.2f, 0.0f, -0.8f),
            new Vector3f(-4.2f, 0.0f, -0.9f),
            new Vector3f(-4.2f, 0.0f, -1.0f),
            new Vector3f(-4.2f, 0.0f, -1.1f),
            new Vector3f(-4.2f, 0.0f, -1.2f),
            new Vector3f(-4.2f, 0.0f, -1.3f),
            new Vector3f(-4.2f, 0.0f, -1.4f),
            new Vector3f(-4.2f, 0.0f, -1.5f),
            new Vector3f(-4.2f, 0.0f, -1.6f),
            new Vector3f(-4.2f, 0.0f, -1.7f),
            new Vector3f(-4.2f, 0.0f, -1.8f),
            new Vector3f(-4.2f, 0.0f, -1.9f),
            new Vector3f(-4.2f, 0.0f, -2.0f),
            new Vector3f(-4.2f, 0.0f, -2.1f),
            new Vector3f(-4.2f, 0.0f, -2.2f),
            new Vector3f(-4.2f, 0.0f, -2.3f),
            new Vector3f(-4.2f, 0.0f, -2.4f),
            new Vector3f(-4.2f, 0.0f, -2.5f),
            new Vector3f(-4.2f, 0.0f, -2.6f),
            new Vector3f(-4.2f, 0.0f, -2.7f),
            new Vector3f(-4.2f, 0.0f, -2.8f),
            new Vector3f(-4.2f, 0.0f, -2.9f),
            new Vector3f(-4.2f, 0.0f, -3.0f),
            new Vector3f(-4.2f, 0.0f, -3.1f),
            new Vector3f(-4.2f, 0.0f, -3.2f),
            new Vector3f(-4.2f, 0.0f, -3.3f),
            new Vector3f(-4.2f, 0.0f, -3.4f),
            new Vector3f(-4.2f, 0.0f, 5.8f),
            new Vector3f(-4.2f, 0.0f, 5.7f),
            new Vector3f(-4.2f, 0.0f, 5.6f),
            new Vector3f(-4.2f, 0.0f, 5.5f),
            new Vector3f(-4.2f, 0.0f, 5.4f),
            new Vector3f(-4.2f, 0.0f, 5.3f),
            new Vector3f(-4.2f, 0.0f, 5.2f),
            new Vector3f(-4.2f, 0.0f, 5.1f),
            new Vector3f(-4.2f, 0.0f, 5.0f),
            new Vector3f(-4.2f, 0.0f, 4.9f),
            new Vector3f(-4.2f, 0.0f, 4.7f),
            new Vector3f(-4.2f, 0.0f, 4.8f),
            new Vector3f(-4.2f, 0.0f, 4.6f),
            new Vector3f(-4.2f, 0.0f, 4.5f),
            new Vector3f(-4.2f, 0.0f, 4.4f),
            new Vector3f(-4.2f, 0.0f, 4.3f),
            new Vector3f(-4.2f, 0.0f, 4.2f),
            new Vector3f(-4.2f, 0.0f, 4.1f),
            new Vector3f(-4.2f, 0.0f, 4.0f),
            new Vector3f(-4.2f, 0.0f, 3.9f),
            new Vector3f(-4.2f, 0.0f, 3.8f),
            new Vector3f(-4.2f, 0.0f, 3.7f),
            new Vector3f(-4.2f, 0.0f, 3.6f),
            new Vector3f(-4.2f, 0.0f, 3.5f),
            new Vector3f(-4.2f, 0.0f, 3.4f),
            new Vector3f(-4.2f, 0.0f, 3.3f),
            new Vector3f(-4.2f, 0.0f, 3.2f),
            new Vector3f(-4.2f, 0.0f, 3.1f),
            new Vector3f(-4.2f, 0.0f, 3.0f),
            new Vector3f(-4.2f, 0.0f, 2.9f),
            new Vector3f(-4.2f, 0.0f, 2.8f),
            new Vector3f(-4.2f, 0.0f, 2.7f),
            new Vector3f(-4.2f, 0.0f, 2.6f),
            new Vector3f(-4.2f, 0.0f, 2.5f),
            new Vector3f(-4.2f, 0.0f, 2.4f),
            new Vector3f(-4.2f, 0.0f, 2.3f),
            new Vector3f(-4.2f, 0.0f, 2.2f),
            new Vector3f(-4.2f, 0.0f, 2.1f),
            new Vector3f(-4.2f, 0.0f, 2.0f),
            new Vector3f(-4.2f, 0.0f, 1.9f),
            new Vector3f(-4.2f, 0.0f, 1.8f),
            new Vector3f(-4.2f, 0.0f, 1.7f),
            new Vector3f(-4.2f, 0.0f, 1.6f),
            new Vector3f(-4.2f, 0.0f, 1.5f),
            new Vector3f(-4.2f, 0.0f, 1.4f),
            new Vector3f(-4.2f, 0.0f, 1.3f),
            new Vector3f(-4.2f, 0.0f, 1.2f),
            new Vector3f(-4.2f, 0.0f, 1.1f),
            new Vector3f(-4.2f, 0.0f, 1.0f),
            new Vector3f(-4.2f, 0.0f, 5.9f),
            new Vector3f(-4.2f, 0.0f, 6.0f),
            new Vector3f(-4.2f, 0.0f, 6.1f),
            new Vector3f(-4.2f, 0.0f, 6.2f),
            new Vector3f(-4.2f, 0.0f, 6.3f),
            new Vector3f(-4.2f, 0.0f, 6.4f),
            new Vector3f(-4.2f, 0.0f, 6.5f),
            new Vector3f(-4.2f, 0.0f, 6.6f),
            new Vector3f(-4.2f, 0.0f, 6.7f),
            new Vector3f(-4.2f, 0.0f, 6.8f),
            new Vector3f(-4.2f, 0.0f, 6.9f),
            new Vector3f(-4.2f, 0.0f, 7.0f),
            new Vector3f(-4.2f, 0.0f, 7.1f),
            new Vector3f(-4.2f, 0.0f, 7.2f),
            new Vector3f(-4.2f, 0.0f, 7.3f),
            new Vector3f(-4.2f, 0.0f, 7.4f),
            new Vector3f(-4.2f, 0.0f, 7.5f),
            new Vector3f(-4.2f, 0.0f, 7.6f),
            new Vector3f(-4.2f, 0.0f, 7.7f),
            new Vector3f(-4.2f, 0.0f, 7.8f),
            new Vector3f(-4.2f, 0.0f, 7.9f),
            new Vector3f(-4.2f, 0.0f, 8.0f),
            new Vector3f(-4.2f, 0.0f, 8.1f),
            new Vector3f(-4.2f, 0.0f, 8.2f),
            new Vector3f(-4.2f, 0.0f, 8.3f),
            new Vector3f(-4.2f, 0.0f, 8.4f),
            new Vector3f(-4.2f, 0.0f, 8.5f),
            new Vector3f(-4.2f, 0.0f, 8.6f),
            new Vector3f(-4.2f, 0.0f, 8.7f),
            new Vector3f(-4.2f, 0.0f, 8.8f),
            new Vector3f(-4.2f, 0.0f, 8.9f),
            new Vector3f(-4.2f, 0.0f, 9.0f),
            new Vector3f(-4.2f, 0.0f, 9.1f),
            new Vector3f(-4.2f, 0.0f, 9.2f),
            new Vector3f(-4.2f, 0.0f, 9.3f),
            new Vector3f(-4.2f, 0.0f, 9.4f),
            new Vector3f(-4.2f, 0.0f, 9.5f),
            new Vector3f(-4.2f, 0.0f, 9.6f),
            new Vector3f(-4.2f, 0.0f, 9.7f),
            new Vector3f(-4.2f, 0.0f, 9.8f),
            new Vector3f(-4.2f, 0.0f, 9.9f),
            new Vector3f(-4.2f, 0.0f, 10.0f),
            new Vector3f(-4.2f, 0.0f, 10.1f),
            new Vector3f(-4.2f, 0.0f, 10.2f),
            new Vector3f(-4.2f, 0.0f, 10.3f),
            new Vector3f(-4.2f, 0.0f, 10.4f),
            new Vector3f(-4.2f, 0.0f, 10.5f),
            new Vector3f(-4.2f, 0.0f, 10.6f),
            new Vector3f(-4.2f, 0.0f, 10.7f),
            new Vector3f(-4.2f, 0.0f, 10.8f),
            new Vector3f(-4.2f, 0.0f, 10.9f),
            new Vector3f(-4.2f, 0.0f, 11.0f),
            new Vector3f(-4.2f, 0.0f, 11.1f),
            new Vector3f(-4.2f, 0.0f, 11.2f),
            new Vector3f(-4.2f, 0.0f, 11.3f),
            new Vector3f(-1.48f, 0.0f, 14.4f),
            new Vector3f(-4.2f, 0.0f, 5.9f),
            new Vector3f(-4.1f, 0.0f, 5.9f),
            new Vector3f(-4.0f, 0.0f, 5.9f),
            new Vector3f(-3.9f, 0.0f, 5.9f),
            new Vector3f(-3.8f, 0.0f, 5.9f),
//            new Vector3f(-3.7f, 0.0f, 5.9f),
            new Vector3f(-3.6f, 0.0f, 5.9f),
            new Vector3f(6.5f, 0.0f, 5.8f),
            new Vector3f(6.5f, 0.0f, 5.7f),
            new Vector3f(6.5f, 0.0f, 5.6f),
            new Vector3f(6.5f, 0.0f, 5.5f),
            new Vector3f(6.5f, 0.0f, 5.4f),
            new Vector3f(6.5f, 0.0f, 5.3f),
            new Vector3f(6.5f, 0.0f, 5.2f),
            new Vector3f(6.5f, 0.0f, 5.1f),
            new Vector3f(6.5f, 0.0f, 5.0f),
            new Vector3f(6.5f, 0.0f, 4.9f),
            new Vector3f(6.5f, 0.0f, 4.8f),
            new Vector3f(6.5f, 0.0f, 4.7f),
            new Vector3f(6.5f, 0.0f, 4.6f),
            new Vector3f(6.5f, 0.0f, 4.5f),
            new Vector3f(6.5f, 0.0f, 4.4f),
            new Vector3f(6.5f, 0.0f, 4.3f),
            new Vector3f(6.5f, 0.0f, 4.2f),
            new Vector3f(6.5f, 0.0f, 4.1f),
            new Vector3f(6.5f, 0.0f, 4.0f),
            new Vector3f(6.5f, 0.0f, 3.9f),
            new Vector3f(6.5f, 0.0f, 3.8f),
            new Vector3f(6.5f, 0.0f, 3.7f),
            new Vector3f(6.5f, 0.0f, 3.6f),
            new Vector3f(6.5f, 0.0f, 3.5f),
            new Vector3f(6.5f, 0.0f, 3.4f),
            new Vector3f(6.5f, 0.0f, 3.3f),
            new Vector3f(6.4f, 0.0f, 2.6f),
            new Vector3f(6.2f, 0.0f, 2.6f),
            new Vector3f(6.3f, 0.0f, 2.6f),
            new Vector3f(6.1f, 0.0f, 2.6f),
            new Vector3f(6.0f, 0.0f, 2.6f),
            new Vector3f(5.9f, 0.0f, 2.6f),
            new Vector3f(-3.99f, 0.0f, 16.1f),
            new Vector3f(-3.89f, 0.0f, 16.1f),
            new Vector3f(-3.79f, 0.0f, 16.1f),
            new Vector3f(-3.69f, 0.0f, 16.1f),
            new Vector3f(-3.59f, 0.0f, 16.1f),
            new Vector3f(-3.49f, 0.0f, 16.1f),
            new Vector3f(-3.39f, 0.0f, 16.1f),
            new Vector3f(-3.29f, 0.0f, 16.1f),
            new Vector3f(-3.19f, 0.0f, 16.1f),
            new Vector3f(-3.09f, 0.0f, 16.1f),
            new Vector3f(-4.09f, 0.0f, 16.1f),
            new Vector3f(-4.19f, 0.0f, 16.1f),
            new Vector3f(-4.29f, 0.0f, 16.1f),
            new Vector3f(-4.39f, 0.0f, 16.1f),
            new Vector3f(-4.49f, 0.0f, 16.1f),
            new Vector3f(-4.59f, 0.0f, 16.1f),
            new Vector3f(-4.69f, 0.0f, 16.1f),
            new Vector3f(-4.79f, 0.0f, 16.1f),
            new Vector3f(-2.99f, 0.0f, 16.1f),
            new Vector3f(-2.89f, 0.0f, 16.1f),
            new Vector3f(-2.79f, 0.0f, 16.1f),
            new Vector3f(-2.69f, 0.0f, 16.1f),
            new Vector3f(-2.59f, 0.0f, 16.1f),
            new Vector3f(-2.49f, 0.0f, 16.1f),
            new Vector3f(-2.39f, 0.0f, 16.1f),
            new Vector3f(-2.29f, 0.0f, 16.1f),
            new Vector3f(-2.19f, 0.0f, 16.1f),
            new Vector3f(-2.09f, 0.0f, 16.1f),
            new Vector3f(0.2f, 0.0f, 16.1f),
            new Vector3f(0.2f, 0.0f, 16.0f),
            new Vector3f(0.2f, 0.0f, 15.9f),
            new Vector3f(0.2f, 0.0f, 15.8f),
            new Vector3f(0.2f, 0.0f, 15.7f),
            new Vector3f(0.2f, 0.0f, 15.6f),
            new Vector3f(0.2f, 0.0f, 15.5f),
            new Vector3f(0.2f, 0.0f, 15.4f),
            new Vector3f(0.2f, 0.0f, 15.3f),
            new Vector3f(0.2f, 0.0f, 15.2f),
            new Vector3f(0.2f, 0.0f, 15.1f),
            new Vector3f(0.2f, 0.0f, 15.0f),
            new Vector3f(0.2f, 0.0f, 14.9f),
            new Vector3f(0.2f, 0.0f, 14.8f),
            new Vector3f(0.2f, 0.0f, 14.7f),
            new Vector3f(0.2f, 0.0f, 14.6f),
            new Vector3f(0.2f, 0.0f, 14.5f),
            new Vector3f(0.2f, 0.0f, 14.4f),
            new Vector3f(-0.9f, 0.0f, 16.0f),
            new Vector3f(-0.8f, 0.0f, 16.0f),
            new Vector3f(-0.7f, 0.0f, 16.0f),
            new Vector3f(-0.6f, 0.0f, 16.0f),
            new Vector3f(-0.5f, 0.0f, 16.0f),
            new Vector3f(-0.4f, 0.0f, 16.0f),
            new Vector3f(-0.3f, 0.0f, 16.0f),
            new Vector3f(-0.2f, 0.0f, 16.0f),
            new Vector3f(-0.1f, 0.0f, 16.0f),
            new Vector3f(-1.0f, 0.0f, 16.0f),
            new Vector3f(-1.1f, 0.0f, 16.0f),
            new Vector3f(-1.2f, 0.0f, 16.0f),
            new Vector3f(-1.3f, 0.0f, 16.0f),
            new Vector3f(-1.4f, 0.0f, 16.0f),
            new Vector3f(-7.59f, 0.0f, 16.0f),
            new Vector3f(-7.59f, 0.0f, 15.9f),
            new Vector3f(-7.59f, 0.0f, 15.8f),
            new Vector3f(-7.59f, 0.0f, 15.7f),
            new Vector3f(-7.59f, 0.0f, 15.6f),
            new Vector3f(-7.59f, 0.0f, 15.5f),
            new Vector3f(-7.59f, 0.0f, 15.4f),
            new Vector3f(-7.59f, 0.0f, 15.3f),
            new Vector3f(-7.59f, 0.0f, 15.2f),
            new Vector3f(-7.59f, 0.0f, 15.1f),
            new Vector3f(-7.59f, 0.0f, 15.0f),
            new Vector3f(-7.59f, 0.0f, 16.0f),
            new Vector3f(-4.099f, 0.0f, -5.89f),
            new Vector3f(6.5f, 0.0f, -5.59f),
            new Vector3f(6.5f, 0.0f, -5.49f),
            new Vector3f(6.5f, 0.0f, -5.39f),
            new Vector3f(6.5f, 0.0f, -5.29f),
            new Vector3f(6.5f, 0.0f, -5.19f),
            new Vector3f(6.5f, 0.0f, -5.09f),
            new Vector3f(6.5f, 0.0f, -4.99f),
            new Vector3f(6.5f, 0.0f, -4.89f),
            new Vector3f(6.5f, 0.0f, -4.79f),
            new Vector3f(6.5f, 0.0f, -4.69f),
            new Vector3f(6.5f, 0.0f, -4.59f),
            new Vector3f(6.5f, 0.0f, -4.49f),
            new Vector3f(6.5f, 0.0f, -4.39f),
            new Vector3f(6.5f, 0.0f, -4.29f),
            new Vector3f(6.5f, 0.0f, -4.19f),
            new Vector3f(6.5f, 0.0f, -4.09f),
            new Vector3f(6.5f, 0.0f, -3.99f),
            new Vector3f(6.5f, 0.0f, -3.89f),
            new Vector3f(6.5f, 0.0f, -3.79f),
            new Vector3f(6.5f, 0.0f, -3.69f),
            new Vector3f(6.5f, 0.0f, -3.59f),
            new Vector3f(6.5f, 0.0f, -3.49f),
            new Vector3f(6.5f, 0.0f, -3.39f),
            new Vector3f(6.5f, 0.0f, -3.29f),
            new Vector3f(6.5f, 0.0f, -3.19f),
            new Vector3f(-11.6f, 0.0f, 1.5f),
            new Vector3f(-11.5f, 0.0f, 1.5f),
            new Vector3f(-11.4f, 0.0f, 1.5f),
            new Vector3f(-11.3f, 0.0f, 1.5f),
            new Vector3f(-11.2f, 0.0f, 1.5f),
            new Vector3f(-11.1f, 0.0f, 1.5f),
            new Vector3f(-11.0f, 0.0f, 1.5f),
            new Vector3f(-10.9f, 0.0f, 1.5f),
            new Vector3f(-10.8f, 0.0f, 1.5f),








            new Vector3f(13.6f, 0.0f, 15.3f),
            new Vector3f(14.8f, 0.0f, 14.0f)


    );

    boolean collision_detection(float posx, float posy, float posz) {
        if (window.isKeyPressed(GLFW_KEY_SPACE)) {
            return false;
        }

        for (Vector3f e : collisionPoint)  {
            if (v3R(posx, posy, posz, e.get(0), e.get(1), e.get(2)) < 0.05f){
                return true;
            }
        }

        return false;
    }
    public void input() {
        int i = 1;

        float posx = kepala.get(0).getCenterPoint().get(0);
        float posy = kepala.get(0).getCenterPoint().get(1);
        float posz = kepala.get(0).getCenterPoint().get(2);

        if (i != 0) {
            for (Sphere kepala : kepala) {
                List<Float> temp = new ArrayList<>(kepala.getCenterPoint());
                kepala.getChildObject().get(15).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                kepala.getChildObject().get(17).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                kepala.getChildObject().get(16).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                kepala.getChildObject().get(18).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                kepala.getChildObject().get(19).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                kepala.getChildObject().get(21).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                kepala.getChildObject().get(20).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                kepala.getChildObject().get(22).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
                if (check) {
                    if (kepala.getChildObject().get(15).getCenterPoint().get(1) >= -0.47f && kepala.getChildObject().get(15).getCenterPoint().get(2) >= -0.08f) {
                        check = false;
                    } else {
                        //lengan kiri
                        kepala.getChildObject().get(15).rotateObject((float) Math.toRadians(0.5f), -1f, 0f, 0f);
                        kepala.getChildObject().get(17).rotateObject((float) Math.toRadians(0.5f), -1f, 0f, 0f);
                        //lengan kanan
                        kepala.getChildObject().get(16).rotateObject((float) Math.toRadians(0.5f), 1f, 0f, 0f);
                        kepala.getChildObject().get(18).rotateObject((float) Math.toRadians(0.5f), 1f, 0f, 0f);
                        //kaki kiri
                        kepala.getChildObject().get(19).rotateObject((float) Math.toRadians(0.5f), 1f, 0f, 0f);
                        kepala.getChildObject().get(21).rotateObject((float) Math.toRadians(0.5f), 1f, 0f, 0f);
                        //kaki kanan
                        kepala.getChildObject().get(20).rotateObject((float) Math.toRadians(0.5f), -1f, 0f, 0f);
                        kepala.getChildObject().get(22).rotateObject((float) Math.toRadians(0.5f), -1f, 0f, 0f);
//                        System.out.println(kepala.getChildObject().get(15).getCenterPoint());
                    }
                } else {
                    if (kepala.getChildObject().get(15).getCenterPoint().get(1) <= -0.49f && kepala.getChildObject().get(15).getCenterPoint().get(2) <= -0.08f) {
                        check = true;
                    } else {
                        //lengan kiri
                        kepala.getChildObject().get(15).rotateObject((float) Math.toRadians(0.5f), 1f, 0f, 0f);
                        kepala.getChildObject().get(17).rotateObject((float) Math.toRadians(0.5f), 1f, 0f, 0f);
                        //lengan kanan
                        kepala.getChildObject().get(16).rotateObject((float) Math.toRadians(0.5f), -1f, 0f, 0f);
                        kepala.getChildObject().get(18).rotateObject((float) Math.toRadians(0.5f), -1f, 0f, 0f);
                        //kaki kiri
                        kepala.getChildObject().get(19).rotateObject((float) Math.toRadians(0.5f), -1f, 0f, 0f);
                        kepala.getChildObject().get(21).rotateObject((float) Math.toRadians(0.5f), -1f, 0f, 0f);
                        //kaki kanan
                        kepala.getChildObject().get(20).rotateObject((float) Math.toRadians(0.5f), 1f, 0f, 0f);
                        kepala.getChildObject().get(22).rotateObject((float) Math.toRadians(0.5f), 1f, 0f, 0f);

//                        System.out.println(kepala.getChildObject().get(15).getCenterPoint());
                    }
                }
                kepala.getChildObject().get(15).translateObject(temp.get(0), temp.get(1), temp.get(2));
                kepala.getChildObject().get(17).translateObject(temp.get(0), temp.get(1), temp.get(2));
                kepala.getChildObject().get(16).translateObject(temp.get(0), temp.get(1), temp.get(2));
                kepala.getChildObject().get(18).translateObject(temp.get(0), temp.get(1), temp.get(2));
                kepala.getChildObject().get(19).translateObject(temp.get(0), temp.get(1), temp.get(2));
                kepala.getChildObject().get(21).translateObject(temp.get(0), temp.get(1), temp.get(2));
                kepala.getChildObject().get(20).translateObject(temp.get(0), temp.get(1), temp.get(2));
                kepala.getChildObject().get(22).translateObject(temp.get(0), temp.get(1), temp.get(2));
            }
        }
        if (change == 1) {
            if (roofCount == 2) {
                standing.get(0).getChildObject().get(0).translateObject(0f, -3f, 0f);
                standing.get(0).getChildObject().get(1).translateObject(0f, -4f, 0f);
                roofCount = 1;
            }
            if (window.isKeyPressed(GLFW_KEY_W) && !collision_detection(posx, posy, posz)) {
                camera.setPosition(kepala.get(0).getCenterPoint().get(0), kepala.get(0).getCenterPoint().get(1) + 5f, kepala.get(0).getCenterPoint().get(2));
                camera.setRotation(1.5f, 0f, 0f);

                for (Object kepala : kepala
                ) {
                    kepala.translateObject(0f, 0f, -0.1f);
                }
                camera.setPosition(kepala.get(0).getCenterPoint().get(0), kepala.get(0).getCenterPoint().get(1) + 5f, kepala.get(0).getCenterPoint().get(2));
                camera.setRotation(1.5f, 0f, 0f);
//                System.out.println(kepala.get(0).getCenterPoint());
            }
            if (window.isKeyPressed(GLFW_KEY_S) && !collision_detection(posx, posy, posz)) {
//            camera.moveForward(0.1f);
                camera.setPosition(kepala.get(0).getCenterPoint().get(0), kepala.get(0).getCenterPoint().get(1) + 5f, kepala.get(0).getCenterPoint().get(2));
                camera.setRotation(1.5f, 0f, 0f);
                for (Object kepala : kepala
                ) {
                    kepala.translateObject(0f, 0f, 0.1f);

                }
                camera.setPosition(kepala.get(0).getCenterPoint().get(0), kepala.get(0).getCenterPoint().get(1) + 5f, kepala.get(0).getCenterPoint().get(2));
                camera.setRotation(1.5f, 0f, 0f);
//                System.out.println(kepala.get(0).getCenterPoint());
            }
            if (window.isKeyPressed(GLFW_KEY_A) && !collision_detection(posx, posy, posz)) {
                camera.setPosition(kepala.get(0).getCenterPoint().get(0), kepala.get(0).getCenterPoint().get(1) + 5f, kepala.get(0).getCenterPoint().get(2));
                camera.setRotation(1.5f, 0f, 0f);
                for (Sphere kepala : kepala
                ) {
                    kepala.translateObject(-0.1f, 0f, 0f);
                }
                camera.setPosition(kepala.get(0).getCenterPoint().get(0), kepala.get(0).getCenterPoint().get(1) + 5f, kepala.get(0).getCenterPoint().get(2));
                camera.setRotation(1.5f, 0f, 0f);
//                System.out.println(kepala.get(0).getCenterPoint());

            }
            if (window.isKeyPressed(GLFW_KEY_D) && !collision_detection(posx, posy, posz)) {
                camera.setPosition(kepala.get(0).getCenterPoint().get(0), kepala.get(0).getCenterPoint().get(1) + 5f, kepala.get(0).getCenterPoint().get(2));
                camera.setRotation(1.5f, 0f, 0f);
                for (Sphere kepala : kepala
                ) {
                    kepala.translateObject(0.1f, 0f, 0f);
                }

                camera.setPosition(kepala.get(0).getCenterPoint().get(0), kepala.get(0).getCenterPoint().get(1) + 5f, kepala.get(0).getCenterPoint().get(2));
                camera.setRotation(1.5f, 0f, 0f);
//                System.out.println(kepala.get(0).getCenterPoint());
            }
        }
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            change = 1;
            camera.setPosition(kepala.get(0).getCenterPoint().get(0), kepala.get(0).getCenterPoint().get(1) + 5f, kepala.get(0).getCenterPoint().get(2));
            camera.setRotation(1.5f, 0f, 0f);
        }
        if (window.isKeyPressed(GLFW_KEY_C)) {
            change = 0;
            camera.setPosition(kepala.get(0).getCenterPoint().get(0), kepala.get(0).getCenterPoint().get(1), kepala.get(0).getCenterPoint().get(2) + 1.5f);
            camera.setRotation(0f, 0f, 0f);
        }
        if (change == 0) {
            if (!isRoofExist) {
                //atap putih
                standing.get(0).getChildObject().add(new Sphere(Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                        new ArrayList<>(
                                List.of(
                                )
                        ),
                        new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                        Arrays.asList(0f, 0f, 0f),
                        0.5f,
                        0.5f,
                        0.5f, 36,
                        18, 1
                ));
                standing.get(0).getChildObject().get(0).translateObject(-0.12f, 1.5f, 0.1f);
                standing.get(0).getChildObject().get(0).scaleObject(60f, 1f, 60f);

                //atap pink
                standing.get(0).getChildObject().add(new Sphere(Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                        new ArrayList<>(
                                List.of(
                                )
                        ),
                        new Vector4f(1.0f, 0.3f, 0.7f, 0.0f),
                        Arrays.asList(0f, 0f, 0f),
                        0.5f,
                        0.5f,
                        0.5f, 36,
                        18, 1
                ));
                standing.get(0).getChildObject().get(1).translateObject(0.75f, 1.5f, 0.8f);
                standing.get(0).getChildObject().get(1).scaleObject(20f, 1f, 20f);
                roofCount = 2;
                isRoofExist = true;
            }
            if (roofCount == 1) {
                standing.get(0).getChildObject().get(0).translateObject(0f, 3f, 0f);
                standing.get(0).getChildObject().get(1).translateObject(0f, 4f, 0f);
                roofCount = 2;
            }

            if (window.isKeyPressed(GLFW_KEY_W)) {
                camera.moveForward(0.1f);
            }
            if (window.isKeyPressed(GLFW_KEY_A)) {
                camera.moveLeft(0.1f);
            }
            if (window.isKeyPressed(GLFW_KEY_D)) {
                camera.moveRight(0.1f);
            }
            if (window.isKeyPressed(GLFW_KEY_S)) {
                camera.moveBackwards(0.1f);
            }
            if (window.getMouseInput().isLeftButtonPressed()) {
                Vector3f displayVec = window.getMouseInput().getDisplVec();
                camera.addRotation((float) Math.toRadians(displayVec.x * 0.1f), (float) Math.toRadians(displayVec.y * 0.1f), 0f);
            }
        }
        if (kepala.get(0).getCenterPoint().get(0) <= -16f && kepala.get(0).getCenterPoint().get(2) >= 16.5f) {
            for (Sphere kepala : kepala
            ) {
                for (Sphere ndas : ndas
                ) {
                    kepala.translateObject(32f, 0f, -1f);
                    ndas.translateObject(32f, 0f, -1f);
                    camera.setPosition(kepala.getCenterPoint().get(0), kepala.getCenterPoint().get(1) + 5f, kepala.getCenterPoint().get(2));
                    camera.setRotation(1.5f, 0f, 0f);
                }
            }

        }
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GL.createCapabilities();

            input();

            for (Sphere standing : standing
            ) {
                standing.draw(camera, projection);
            }
            for (Object lightbulb : lightbulb
            ) {
                lightbulb.draw(camera, projection);
            }
            for (Sphere ruangan : ruangan
            ) {
                ruangan.draw(camera, projection);
            }
            for (Object kepala : kepala
            ) {
                kepala.draw(camera, projection);
            }
            for (Sphere kepala1:kepala1){
                kepala1.draw(camera,projection);
            }
            for (Sphere kepala2:kepala2){
                kepala2.draw(camera,projection);
            }


            //Restore state
            glDisableVertexAttribArray(0);

            //Poll for window events.
            //The key callback above will only be
            //invoked during this call.
            glfwPollEvents();
        }
    }

    public float v3R(float x1, float y1, float z1, float x2, float y2, float z2){
        return (float) Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y2 - y1), 2) + Math.pow(Math.abs(z2 - z1), 2));
    }

    public void run() {
        init();
        loop();
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
