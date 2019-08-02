package EightAM.asteroids;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;

import androidx.annotation.ColorInt;
import androidx.core.content.res.ResourcesCompat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import EightAM.asteroids.specs.AudioSpec;
import EightAM.asteroids.specs.BaseBitmapSpec;
import EightAM.asteroids.specs.BaseObjectSpec;
import EightAM.asteroids.specs.BasicBulletSpec;
import EightAM.asteroids.specs.BasicParticleSpec;
import EightAM.asteroids.specs.BasicShipWeaponSpec;
import EightAM.asteroids.specs.BigAlienSpec;
import EightAM.asteroids.specs.BigAlienWeaponSpec;
import EightAM.asteroids.specs.BombWeaponSpec;
import EightAM.asteroids.specs.GameMusicSpec;
import EightAM.asteroids.specs.KamikazeAlienSpec;
import EightAM.asteroids.specs.LargeAsteroidSpec;
import EightAM.asteroids.specs.LaserBulletSpec;
import EightAM.asteroids.specs.LaserWeaponSpec;
import EightAM.asteroids.specs.LevelAudioSpec;
import EightAM.asteroids.specs.MediumAsteroidSpec;
import EightAM.asteroids.specs.RandomLootSpec;
import EightAM.asteroids.specs.ShotgunWeaponSpec;
import EightAM.asteroids.specs.ShrapnelBulletSpec;
import EightAM.asteroids.specs.SlowLongBulletSpec;
import EightAM.asteroids.specs.SmallAlienBulletSpec;
import EightAM.asteroids.specs.SmallAlienSpec;
import EightAM.asteroids.specs.SmallAsteroidSpec;
import EightAM.asteroids.specs.TeleportShipSpec;

final class AssetLoader {
    static final List<BaseObjectSpec> specList = Collections.unmodifiableList(
            Arrays.asList(new BasicBulletSpec(), new BasicParticleSpec(), new TeleportShipSpec(),
                    new BigAlienSpec(), new SmallAlienSpec(), new KamikazeAlienSpec(),
                    new LargeAsteroidSpec(), new MediumAsteroidSpec(), new SmallAsteroidSpec(),
                    new SlowLongBulletSpec(), new SmallAlienBulletSpec(), new ShrapnelBulletSpec(),
                    new LaserBulletSpec(), new RandomLootSpec()));

    static final List<AudioSpec> audioSpecList = Collections.unmodifiableList(
            Arrays.asList(new BasicShipWeaponSpec(), new BigAlienWeaponSpec(), new BombWeaponSpec(),
                    new LaserWeaponSpec(), new LevelAudioSpec(), new ShotgunWeaponSpec(),
                    new SmallAsteroidSpec())
    );

    private static void loadFont(PaintStore paintStore, Context c) {
        Paint p = new Paint();
        Typeface tf = ResourcesCompat.getFont(c, R.font.retro);
        p.setTypeface(tf);
        paintStore.addPaint("font_paint", p);
    }

    static void load(Context c) {
        BitmapStore bitmapStore = BitmapStore.getInstance();
        PaintStore paintStore = PaintStore.getInstance();
        AudioUtility audioStore = AudioUtility.getInstance();

        loadFont(paintStore, c);

        for (BaseObjectSpec baseSpec : specList) {
            if (baseSpec instanceof BaseBitmapSpec) {
                BaseBitmapSpec spec = (BaseBitmapSpec) baseSpec;
                bitmapStore.addVectorBitmap(c, spec.tag, spec.bitMapResourceID,
                        spec.dimensions, spec.dimensionBitMapRatio);
            }
            try {
                @ColorInt
                int paintColor = (int) baseSpec.getClass().getField("paintColor").get(null);
                Paint.Style paintStyle = (Paint.Style) baseSpec.getClass().getField(
                        "paintStyle").get(null);
                Paint paint = new Paint();
                paint.setStyle(paintStyle);
                paint.setColor(paintColor);
                paint.setAntiAlias(true);
                Log.d(AssetLoader.class.getCanonicalName(),
                        "Loaded: " + baseSpec.tag + ", Color: " + paintColor + ", Style: "
                                + paintStyle.toString());
                paintStore.addPaint(baseSpec.tag, paint);
            } catch (Exception e) {
                Log.d(AssetLoader.class.getCanonicalName(), "Failed to load: " + baseSpec.tag);
            }
            if (baseSpec instanceof AudioSpec) {
                audioStore.loadSound(c, ((AudioSpec) baseSpec).getResIDs());
            }
        }
        for (AudioSpec audioSpec : audioSpecList) {
            audioStore.loadSound(c, audioSpec.getResIDs());
        }

        audioStore.loadMusic(c, new GameMusicSpec().music);
    }
}
