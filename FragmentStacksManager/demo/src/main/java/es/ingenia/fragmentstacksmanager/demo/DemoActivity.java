package es.ingenia.fragmentstacksmanager.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import es.ingenia.fragmentstacksmanager.FragmentStacksManager;
import es.ingenia.fragmentstacksmanager.Stacks;


public class DemoActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    private FragmentStacksManager fragmentStacksManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }

        fragmentStacksManager = new FragmentStacksManager<Fragment>(this,
                R.id.fragment_host, 4) {

            private void showBack(){
                if (getSupportActionBar() != null) {
                    if (fragmentStacksManager.canPopFragment()){
                        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    } else {
                        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                    }
                }
            }

            private void setTitle(String stack){
                switch (stack){
                    case Stacks.OPT_1:
                        DemoActivity.this.setTitle("Home");
                        break;
                    case Stacks.OPT_2:
                        DemoActivity.this.setTitle("Video");
                        break;
                    case Stacks.OPT_3:
                        DemoActivity.this.setTitle("Photo");
                        break;
                    case Stacks.OPT_4:
                        DemoActivity.this.setTitle("Test");
                        break;
                    }

            }

            @Override
            public void whenFragmentIsDisplayed(@NonNull final Fragment fragment) {
                setTitle(fragmentStacksManager.peek());
                showBack();
            }

            @Override
            public void whenFragmentIsRedisplayed(@NonNull final Fragment fragment){
                setTitle(fragmentStacksManager.peek());
                showBack();
            }

            @Override
            public Fragment getDefaultFragment(@NonNull String nextStack) {
                Fragment fragment = null;
                switch (nextStack) {
                    case Stacks.OPT_1:
                        fragment = Fragment.instantiate(getBaseContext(),
                                DemoFragment.class.getName());
                        break;
                    case Stacks.OPT_2:
                        fragment = Fragment.instantiate(getBaseContext(),
                                DemoFragment.class.getName());
                        break;
                    case Stacks.OPT_3:
                        fragment = Fragment.instantiate(getBaseContext(),
                                DemoFragment.class.getName());
                        break;
                    case Stacks.OPT_4:
                        fragment = Fragment.instantiate(getBaseContext(),
                                DemoFragment.class.getName());
                        break;

                }
                if (fragment == null) {
                    throw new IllegalStateException("NextStack no soportado");
                }

                return fragment;

            }
        };

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                String nextTab = null;

                switch (menuItem.getItemId()) {
                    case R.id.home:
                        nextTab = Stacks.OPT_1;
                        break;

                    case R.id.video:
                        nextTab = Stacks.OPT_2;
                        break;

                    case R.id.photo:
                        nextTab = Stacks.OPT_3;
                        break;

                    case R.id.test:
                        nextTab = Stacks.OPT_4;
                        break;
                }
                if (nextTab != null) {
                    fragmentStacksManager.switchStack(nextTab);
                }
                return true;
            }
        });

        fragmentStacksManager.restoreOrInitialize(savedInstanceState);
    }

    /**
     *
     * Método que manejará la pulsación de retorno.
     *
     * La implementación es:
     *
     * Si la pila de navegación actual no está en el fragmento raiz, se hace pop.
     * Si no, si en la pila de navegaciones ya no hay nada más que una (y esta no tenía mas de un elemento) se finaliza
     * Si no, si en la pila de navegaciones hay navegaciones, se hace pop de la pila de navegaciones
     * y se marca como la navegación actual la que había bajo la actual en el momento de retroceder.
     *
     */
    @Override
    public final void onBackPressed() {

        if (fragmentStacksManager.canPopFragment()) {
            fragmentStacksManager.popFragment();
        } else {
            if (!fragmentStacksManager.canPop()) {
                finish();
            } else { // fragmentTabStack.size() > 1
                fragmentStacksManager.popStack();
                String optionStack = fragmentStacksManager.peek();
                // se deducirá el menu item index a seleccionar
                int indexOption = -1;
                switch (optionStack) {
                    case Stacks.OPT_1:
                        indexOption = 0;
                        break;
                    case Stacks.OPT_2:
                        indexOption = 1;
                        break;
                    case Stacks.OPT_3:
                        indexOption = 2;
                        break;
                    case Stacks.OPT_4:
                        indexOption = 4;
                        break;
                }
                // selección de pestaña
                bottomNavigationView.getMenu().getItem(indexOption).setChecked(true);
            }
        }
    }

    public void pushNewFragmentOnStack(int level){
        Bundle bundle = new Bundle();
        bundle.putInt("level", level);
        Fragment fragment = Fragment.instantiate(getApplicationContext(),
                DemoFragment.class.getName(), bundle);
        fragmentStacksManager.pushFragment(fragment);

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}